package airlineDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Statements {

//  CUSTOMER FUNCTIONS

	public static void createReservation(Connection conn) throws IOException, SQLException {
		try {
			Statement stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String flightNumber = null;
			String date = null;
			String seatNumber = null;
			String customerName = null;
			String customerPhone = null;
			String exists = "";
			String leg = "1";
			int leg1;

			try {
				System.out.println("Enter flight number: ");
				flightNumber = br.readLine();
				System.out.println("Enter date (yyyy-mm-dd): ");
				date = br.readLine();
				System.out.println("Enter customer name: ");
				customerName = br.readLine();
				System.out.println("Enter customer phone (XXX-XXX-XXXX): ");
				customerPhone = br.readLine();

				String queryString5 = "select * from leginstances where fnum = '" + flightNumber + "' and ldate = '"
						+ date + "'";

				ResultSet rs = stmt.executeQuery(queryString5);
				while (rs.next()) {
					exists = rs.getString("fnum");
				}
				if (exists.equals("") | exists.equals(null)) {
					System.out.println("Flight Does Not Exist OR Does Not Fly On This Date");
				} else {
					while (!exists.equals("") && !exists.equals(null)) {

						String queryString1 = "select * from leginstances where fnum = '" + flightNumber
								+ "' and lnum = '" + leg + "' and ldate = '" + date + "';";

						rs = stmt.executeQuery(queryString1);
						while (rs.next()) {
							seatNumber = rs.getString("availseats");
						}

						if (Integer.parseInt(seatNumber) > 0) {
							conn.setAutoCommit(false);

							String queryString = "insert into reservations values('" + flightNumber + "','" + leg
									+ "','" + date + "','" + seatNumber + "','" + customerName + "','" + customerPhone
									+ "');";
							stmt.executeUpdate(queryString);
							String queryString2 = "update leginstances set availseats = availseats - 1 "
									+ "where fnum = '" + flightNumber + "' and lnum = '" + leg + "' and ldate = '"
									+ date + "'";
							stmt.executeUpdate(queryString2);

							conn.commit();
							conn.setAutoCommit(true);

							System.out.print("\n\nReservation Made \nFlight Number: " + flightNumber + " \nLeg Number: "
									+ leg + " \nDate: " + date + " \nSeat Number: " + seatNumber + " \nCustomer Name: "
									+ customerName + " \nCustomer Phone: " + customerPhone);
						} else {
							System.out.print("Reservation Failed, All Seats Are Booked");
							break;
						}

						leg1 = Integer.parseInt(leg) + 1;
						leg = Integer.toString(leg1);
						String queryString6 = "select * from leginstances where fnum = '" + flightNumber
								+ "' and lnum = '" + leg + "' and ldate = '" + date + "'";

						rs = stmt.executeQuery(queryString6);
						while (rs.next()) {
							exists = rs.getString("availseats");
						}
					}
				}
			} catch (IllegalArgumentException iae) {
				System.out.println("Reservation Failed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			conn.rollback();
		}
		continueMenu();
	}

	public static void cancelReservation(Connection conn) throws IOException, SQLException {
		try {
			Statement stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String flightNumber = null;
			String date = null;
			String seatNumber = null;

			try {

				System.out.println("Enter flight number: ");
				flightNumber = br.readLine();

				System.out.println("Enter date (yyyy-mm-dd): ");
				date = br.readLine();

				System.out.println("Enter seat number: ");
				seatNumber = br.readLine();

				String queryString1 = "select * from reservations where fnum = '" + flightNumber + "' and date = '"
						+ date + "' and seatnum = '" + seatNumber + "'";
				ResultSet rs = stmt.executeQuery(queryString1);

				String reservationExists = "";
				while (rs.next()) {
					reservationExists = rs.getString("seatnum");
				}

				if (reservationExists.equals("")) {
					System.out.print("Reservation Not Cancelled, Does Not Exist");
				} else {
					conn.setAutoCommit(false);

					String queryString2 = "delete from reservations where fnum = '" + flightNumber + "' and date = '"
							+ date + "' and seatnum = '" + seatNumber + "'";
					stmt.executeUpdate(queryString2);

					String queryString3 = "update leginstances set availseats = availseats + 1 " + "where fnum = '"
							+ flightNumber + "' and ldate = '" + date + "'";
					stmt.executeUpdate(queryString3);

					conn.commit();
					conn.setAutoCommit(true);

					System.out.print("Reservation Cancelled \nFlight Number: " + flightNumber + " \nDate: " + date
							+ " \nSeat Number: " + seatNumber);

				}
			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		continueMenu();
	}

	public static void callConfirmReservation() throws IOException, SQLException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String fnum = "";
		String lnum = "";
		String ldate = "";
		String seatnum = "";
		try {
			System.out.println("Enter flight number: ");
			fnum = br.readLine();

			System.out.println("Enter leg number: ");
			lnum = br.readLine();

			System.out.println("Enter date (yyyy-mm-dd): ");
			ldate = br.readLine();

			System.out.println("Enter seat number: ");
			seatnum = br.readLine();

		} catch (IllegalArgumentException iae) {
			System.err.println("Invalid Format!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		confirmReservation(Database.conn, fnum, lnum, ldate, seatnum);
	}

	public static void confirmReservation(Connection conn, String fnum, String lnum, String ldate, String seatnum)
			throws IOException, SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "select * from leginstances natural join reservations where fnum = ? and lnum = ? and ldate = ? and seatnum = ?";

		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, fnum);
		pstmt.setString(2, lnum);
		pstmt.setString(3, ldate);
		pstmt.setString(4, seatnum);
		rs = pstmt.executeQuery();

		if (rs.next()) {

			System.out.println("\n" + "RESERVATION CONFIRMED" + "\n");
			String flightNumber = rs.getString("fnum");
			String legNumber = rs.getString("lnum");
			String legDate = rs.getString("ldate");
			String seatNumber = rs.getString("seatnum");
			String customerName = rs.getString("customername");
			String airplaneId = rs.getString("airplaneid");
			String departCode = rs.getString("departcode");
			String departTime = rs.getString("departtime");
			String arrivalCode = rs.getString("arrivalcode");
			String arrivalTime = rs.getString("arrivaltime");

			System.out.println("Customer Name: " + customerName);
			System.out.println("Flight Number: " + flightNumber);
			System.out.println("Leg Number: " + legNumber);
			System.out.println("Date: " + legDate);
			System.out.println("Airplane ID: " + airplaneId);
			System.out.println("Departure Code: " + departCode);
			System.out.println("Arrival Code: " + arrivalCode);
			System.out.println("Departure Time: " + departTime);
			System.out.println("Arrival Time: " + arrivalTime);
			System.out.println("Seat Number: " + seatNumber);
			System.out.println();

		} else {
			System.out.println("Reservation Does Not Exist");
		}
		continueMenu();
	}

	public static void printTripItinerary(Connection conn) throws IOException, SQLException {

		String customer = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Customer Name:  ");
		try {
			customer = br.readLine();
		} catch (IllegalArgumentException iae) {
			System.err.println("Invalid Format!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PreparedStatement tripItinerary = null;

		String selectSQL = "select * from leginstances natural join reservations where customername = ?"
				+ " and ldate = date;";

		try {

			tripItinerary = conn.prepareStatement(selectSQL);
			tripItinerary.setString(1, customer);

			ResultSet rs = tripItinerary.executeQuery();
			System.out.print("\n" + "\n" + "\t" + "TRIP ITINERARY" + "\n");
			while (rs.next()) {

				System.out.println();
				String fnum = rs.getString("fnum");
				String lnum = rs.getString("lnum");
				String date = rs.getString("date");
				String seatnum = rs.getString("seatnum");
				String customername = rs.getString("customername");
				String airplaneid = rs.getString("airplaneid");
				String departcode = rs.getString("departcode");
				String departtime = rs.getString("departtime");
				String arrivalcode = rs.getString("arrivalcode");
				String arrivaltime = rs.getString("arrivaltime");

				System.out.println("Customer Name: " + customername);
				System.out.println("Flight Number: " + fnum);
				System.out.println("Leg Number: " + lnum);
				System.out.println("Date: " + date);
				System.out.println("Airplane ID: " + airplaneid);
				System.out.println("Departure Code: " + departcode);
				System.out.println("Arrival Code: " + arrivalcode);
				System.out.println("Departure Time: " + departtime);
				System.out.println("Arrival Time: " + arrivaltime);
				System.out.println("Seat Number: " + seatnum);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (tripItinerary != null) {
				tripItinerary.close();
			}
		}
		continueMenu();
	}

	public static void locateFare(Connection conn) throws IOException, SQLException {
		try {
			Statement stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String flightNumber = "";

			try {
				System.out.println("Enter Flight Number: ");
				flightNumber = br.readLine();

				String queryString = "select fnum, amount " + "from fares where fnum = '" + flightNumber + "'";

				ResultSet rset = stmt.executeQuery(queryString);

				while (rset.next()) {
					System.out.println(
							"\n" + "Flight Number: " + rset.getString(1) + "\n" + "Fare: $" + rset.getString(2));
				}

			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueMenu();
	}

	public static void cheapFlight(Connection conn) throws IOException, SQLException {
		try {
			Statement stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String price = "";
			String departcode = "";
			String date = "";

			try {

				System.out.println("Enter Maximum Price: ");
				price = br.readLine();

				System.out.println("Enter Departure Code: ");
				departcode = br.readLine();

				System.out.println("Enter Date: ");
				date = br.readLine();

				String queryString = "select * from (select * from fares where amount < " + price + ") as cheapfare "
						+ " natural join leginstances where departcode = '" + departcode + "' and ldate = '" + date
						+ "'";

				ResultSet rset = stmt.executeQuery(queryString);

				while (rset.next()) {
					System.out.println(rset.getString(1) + "\t" + rset.getString(3) + "\t" + rset.getString(6) + "\t"
							+ rset.getString(7) + "\t" + rset.getString(9) + "\t" + rset.getString(10) + "\t"
							+ rset.getString(11) + "\t" + rset.getString(12));
				}

			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueMenu();
	}

//  REPORTING FUNCTIONS

	public static void flightroster(Connection conn) throws IOException, SQLException {
		try {
			Statement stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String flightnumber = null;
			String legnumber = null;
			String date = null;

			try {
				System.out.println("Enter flight number: ");
				flightnumber = br.readLine();

				System.out.println("Enter leg number: ");
				legnumber = br.readLine();

				System.out.println("Enter date (yyyy-mm-dd): ");
				date = br.readLine();

				String queryString = "select customername from (select * from reservations where fnum = '"
						+ flightnumber + "' and lnum = '" + legnumber + "' and date = '" + date + "') as cn";

				ResultSet rset = stmt.executeQuery(queryString);

				while (rset.next()) {
					System.out.println(rset.getString(1));
				}

			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueMenu();
	}

	public static void flightschedule(Connection conn) throws IOException, SQLException {
		try {
			Statement stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// fnum lnum date
			String airline = null;
			String departcode = null;
			String arrivalcode = null;

			try {
				System.out.println("Enter airline: ");
				airline = br.readLine();

				System.out.println("Enter departure code: ");
				departcode = br.readLine();

				System.out.println("Enter arrival code: ");
				arrivalcode = br.readLine();

				String queryString = "select fnum, airline, departcode, arrivalcode, ldate, departtime, arrivaltime "
						+ "from leginstances natural join flights where airline = '" + airline + "' and departcode = '"
						+ departcode + "' and arrivalcode = '" + arrivalcode + "'";

				ResultSet rset = stmt.executeQuery(queryString);

				while (rset.next()) {
					System.out.println(rset.getString(1) + "\t" + rset.getString(2) + "\t" + rset.getString(3) + "\t"
							+ rset.getString(4) + "\t" + rset.getString(5) + "\t" + rset.getString(6) + "\t"
							+ rset.getString(7));
				}

			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueMenu();
	}

	public static void performanceReport(Connection conn) throws IOException, SQLException {
		try {
			Statement stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String airline = null;
			String date = null;

			try {
				System.out.println("Enter airline: ");
				airline = br.readLine();

				System.out.println("Enter date (yyyy-mm-dd): ");
				date = br.readLine();

				String queryString = "select fnum, airline, departcode, arrivalcode, ldate, departtime,"
						+ " arrivaltime, status from leginstances natural join flights where airline = '" + airline
						+ "' and ldate = '" + date + "'";

				ResultSet rset = stmt.executeQuery(queryString);

				while (rset.next()) {
					System.out.println(rset.getString(1) + "\t" + rset.getString(2) + "\t" + rset.getString(3) + "\t"
							+ rset.getString(4) + "\t" + rset.getString(5) + "\t" + rset.getString(6) + "\t"
							+ rset.getString(7) + "\t" + rset.getString(8));
				}

			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueMenu();
	}

	public static void flightHistory(Connection conn) throws IOException, SQLException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String flightnumber = null;
			String legnumber = null;

			try {
				System.out.println("Enter flight number: ");
				flightnumber = br.readLine();

				System.out.println("Enter leg number: ");
				legnumber = br.readLine();

				CallableStatement cs = conn.prepareCall("{call flightHistory(?, ?, ?)}");

				cs.setString(1, flightnumber);
				cs.setString(2, legnumber);
				cs.registerOutParameter(3, Types.FLOAT);

				cs.executeQuery();

				float minuteslate = cs.getFloat(3);

				System.out.println("Average flight is " + minuteslate + " minutes late. ");

			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueMenu();
	}

//	Administrative Functions	

//  ADMINISTRATIVE FUNCTIONS

	public static void addDropFlight(Connection conn) throws IOException, SQLException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\n" + "(1) Add flight" + "\n" + "(2) Drop flight" + "\n" + "Selection: ");
		int select = 0;
		try {
			select = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (select == 1) {
			Statements.addFlight(Database.conn);
		} else if (select == 2) {
			Statements.dropFlight(Database.conn);
		}
	}

	public static void addFlight(Connection conn) throws IOException, SQLException {
		try {
			Statement stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int farecode = 0;

			try {
				System.out.println("Enter flight number code: ");
				String fnum = br.readLine();

				System.out.println("Enter airline: ");
				String airline = br.readLine();

				System.out.println("Enter fare amount: ");
				String fare = br.readLine();

				System.out.println("Enter restrictions: ");
				String restrictions = br.readLine();

				String updateString = "insert into flights values ('" + fnum + "','" + airline + "','MTWRFSU');";
				stmt.executeUpdate(updateString);

				String queryString1 = "select count(farecode) as fareNum from fares";

				ResultSet rs = stmt.executeQuery(queryString1);

				while (rs.next()) {
					farecode = Integer.parseInt(rs.getString("fareNum")) + 1;
				}

				String farecode1 = Integer.toString(farecode);
				String updateString1 = "insert into fares values ('" + fnum + "','" + farecode1 + "','" + fare + "','"
						+ restrictions + "')";
				stmt.executeUpdate(updateString1);

				String leg = "0";
				int leg1 = Integer.parseInt(leg) + 1;
				leg = Integer.toString(leg1);
				String departCode = "";
				String done = "1";

				while (done.equals("1")) {
					if (departCode.equals("")) {
						System.out.println("Enter departure code: ");
						departCode = br.readLine();
					}
					System.out.println("Enter departure time: ");
					String departTime = br.readLine();

					System.out.println("Enter arrival code: ");
					String arrivalCode = br.readLine();

					System.out.println("Enter arrival time: ");
					String arrivalTime = br.readLine();

					String updateString2 = "insert into legs values ('" + fnum + "','" + leg + "','" + departCode
							+ "','" + departTime + "','" + arrivalCode + "','" + arrivalTime + "');";

					stmt.executeUpdate(updateString2);

					departCode = arrivalCode;

					System.out.print("\n" + "\n" + "Continue adding legs?" + "\n" + "(1) Continue" + "\n" + "(2) Quit"
							+ "\n" + "\n" + "Selection:  ");
					try {
						int selection = Integer.parseInt(br.readLine());
						if (selection == 1) {
							done = "1";
							leg1 = Integer.parseInt(leg) + 1;
							leg = Integer.toString(leg1);
						} else if (selection == 2) {
							done = "2";
						} else {
							System.out.println("Invalid Entry");
						}
					} catch (IllegalArgumentException iae) {
						System.out.println("Invalid Entry");
					}
				}

				System.out.print("Flight " + fnum + " with " + leg + " leg(s) added to database");

			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueMenu();
	}

	public static void dropFlight(Connection conn) throws IOException, SQLException {
		try {
			Statement stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String exists = "";
			try {
				System.out.println("Enter flight number: ");
				String fnum = br.readLine();
				String queryString = "select * from flights where fnum = '" + fnum + "'";

				ResultSet rs = stmt.executeQuery(queryString);

				while (rs.next()) {
					exists = rs.getString("fnum");
				}
				if (exists.equals("")) {
					System.out.print("Flight " + fnum + " not removed from database, does not exist");
				} else {

					String updateString = "delete from flights where fnum = '" + fnum + "'";
					stmt.executeUpdate(updateString);

					String updateString1 = "delete from fares where fnum = '" + fnum + "'";
					stmt.executeUpdate(updateString1);

					System.out.print("Flight " + fnum + " removed from database");
				}
			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueMenu();
	}

	public static void addAirport(Connection conn) throws IOException, SQLException {
		try {
			Statement stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String code = null;
			String name = null;
			String city = null;
			String state = null;

			try {
				System.out.println("Enter airport code: ");
				code = br.readLine();

				System.out.println("Enter airport name: ");
				name = br.readLine();

				System.out.println("Enter city : ");
				city = br.readLine();

				System.out.println("Enter state abbreviation: ");
				state = br.readLine();

				String updateString = "insert into airports values ('" + code + "','" + name + "','" + city + "','"
						+ state + "')";

				stmt.executeUpdate(updateString);

				System.out.print("Airport " + name + " added to database");

			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueMenu();
	}

	public static void updatefares(Connection conn) throws IOException, SQLException {
		try {
			Statement stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String flightnumber = null;
			String farecode = null;
			Float amount = null;
			String restrictions = null;

			try {
				System.out.println("Enter flight number: ");
				flightnumber = br.readLine();

				System.out.println("Enter amount : ");
				amount = Float.parseFloat(br.readLine());

				System.out.println("Enter restrictions: ");
				restrictions = br.readLine();

				String queryString = "select * from fares where fnum = '" + flightnumber + "';";

				ResultSet rset = stmt.executeQuery(queryString);

				String fareExists = "";
				while (rset.next()) {
					fareExists = rset.getString("farecode");
				}

				if (fareExists.equals("")) {
					System.out.print("Fare Not Updated, Does Not Exist");
				} else {

					String updateString = "update fares set amount = '" + amount + "'" + " where fnum = '"
							+ flightnumber + "' and farecode = '" + farecode + "'";

					stmt.executeUpdate(updateString);

					String updateString2 = "update fares set restrictions = '" + restrictions + "'" + " where fnum = '"
							+ flightnumber + "' and farecode = '" + farecode + "'";

					stmt.executeUpdate(updateString2);

					System.out.print("Fare Updated \nAmount: " + amount + " \nrestrictions: " + restrictions);
				}

			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueMenu();
	}

	public static void addLegInstance(Connection conn) throws IOException, SQLException {
		try {
			Statement stmt = conn.createStatement();
			Statement stmt2 = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String departCode = "";
			String departTime = "";
			String arrivalCode = "";
			String arrivalTime = "";

			try {
				System.out.println("Enter flight number: ");
				String fnum = br.readLine();
				int lnum = 0;

				System.out.println("Enter leg date (yyyy-mm-dd) : ");
				String ldate = br.readLine();

				System.out.println("Enter available seats: ");
				String availseats = br.readLine();

				System.out.println("Enter airplaneid: ");
				String airplaneid = br.readLine();

				String queryString = "select * from legs where fnum = '" + fnum + "';";
//
				ResultSet rs = stmt.executeQuery(queryString);

				while (rs.next()) {
					departCode = rs.getString("departcode");
					departTime = rs.getString("departtime");
					arrivalCode = rs.getString("arrivalcode");
					arrivalTime = rs.getString("arrivaltime");

					if (departCode.equals("")) {
					} else {
						lnum += 1;
						String updateString = "insert into leginstances values ('" + fnum + "','" + lnum + "','" + ldate
								+ "','" + availseats + "','" + airplaneid + "'," + "'" + departCode + "','" + departTime
								+ "','" + arrivalCode + "','" + arrivalTime + "','00:00:00')";
						stmt2.executeUpdate(updateString);
					}
				}
				System.out.print("Leg instance added to database");
			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueMenu();
	}

	public static void updateLegInstance(Connection conn) throws IOException, SQLException {
		try {
			Statement stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String flightnumber = null;
			String legnumber = null;
			String date = null;
			String departtime = null;
			String arrivaltime = null;

			try {
				System.out.println("Enter flight number: ");
				flightnumber = br.readLine();

				System.out.println("Enter leg number: ");
				legnumber = br.readLine();

				System.out.println("Enter date (yyyy-mm-dd): ");
				date = br.readLine();

				System.out.println("Enter depart time (hh:mm:ss): ");
				departtime = br.readLine();

				System.out.println("Enter arrival time (hh:mm:ss): ");
				arrivaltime = br.readLine();

				String queryString3 = "select * from leginstances where fnum = '" + flightnumber + "' and lnum = '"
						+ legnumber + "' and ldate = '" + date + "'";

				ResultSet rs = stmt.executeQuery(queryString3);
				String exists = "";
				while (rs.next()) {
					exists = rs.getString("fnum");
				}
				if (exists.equals("")) {
					System.out.print("Leg Instance Not Updated, Does Not Exist");
				} else {
					String queryString = "update leginstances set status = timediff('" + departtime
							+ "', departtime) where fnum = '" + flightnumber + "' and lnum = '" + legnumber
							+ "' and ldate = '" + date + "'";

					stmt.executeUpdate(queryString);

					String queryString2 = "update leginstances set departtime = '" + departtime + "' , arrivaltime = '"
							+ arrivaltime + "' where fnum = '" + flightnumber + "' and lnum = '" + legnumber
							+ "' and ldate = '" + date + "'";

					stmt.executeUpdate(queryString2);

					System.out.print(
							"Leg Instance Updated \nDepart Time: " + departtime + " \nArrival Time: " + arrivaltime);
				}
			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueMenu();
	}

	public static void continueMenu() throws IOException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(
				"\n" + "\n" + "Continue?" + "\n" + "(1) Continue" + "\n" + "(2) Quit" + "\n" + "\n" + "Selection:  ");
		// Find out what was selected, if valid, go to next menu, else, display menu
		// again
		try {
			int selection = Integer.parseInt(br.readLine());
			if (selection == 1) {
				if (Database.view.equals("all")) {
					Menu.mainMenu();
				} else if (Database.view.equals("customer")) {
					Menu.mainMenu1();
				} else if (Database.view.equals("admin")) {
					Menu.administrativeFunctionsMenu();
				}
			} else if (selection == 2) {
				System.out.println("Quitting program...");
			} else {
				System.out.println("Invalid Entry");
				continueMenu();
			}
		} catch (IllegalArgumentException iae) {
			System.out.println("Invalid Entry");
			continueMenu();
		}
	}

}
