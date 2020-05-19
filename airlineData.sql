insert into airports values ('ILM','Wilmington International','Wilmington','NC');
insert into airports values ('SFO','San Francisco International','San Francisco','CA');
insert into airports values ('DEN','Denver International','Denver','CO');
insert into airports values ('MIA','Miami International','Miami','FL');
insert into airports values ('ATL','Hartsfield-Jackson Atlanta International','Atlanta','GA');
insert into airports values ('HNL','Daniel K. Inouye International','Honolulu','HI');
insert into airports values ('ORD','Chicago OHare International','Chicago','IL');
insert into airports values ('JFK','John F. Kennedy International','New York','NY');
insert into airports values ('HOU','George Bush Intercontinental','Houston','TX');
insert into airports values ('DCA','Ronald Reagan Washington National','Washington D.C','DC');

insert into flights values('DL2959','Delta','MTWRFSU');
insert into flights values('AAL2771','American','MTWRFSU');
insert into flights values('U7413','United','MTWRFSU');
insert into flights values('BG899','Delta','MTWRFSU');
insert into flights values('JK554', 'American','MTWRFSU');
insert into flights values('DC123','United','MTWRFSU');
insert into flights values('HO6969','American','MTWRFSU');
insert into flights values('YY717','Delta','MTWRFSU');
insert into flights values('GO100','Delta','MTWRFSU');
insert into flights values('T41CC','American','MTWRFSU');

insert into planetypes values('Boeing747','500','Boeing');
insert into planetypes values('Boeing777','550','Boeing');
insert into planetypes values('Boeing737','200','Boeing');
insert into planetypes values('AirbusA320','175','Airbus');
insert into planetypes values('AirbusA380','600','Airbus');
insert into planetypes values('MitsubishiMRJ','75','Mitsubishi');

insert into airplanes values('747A','500','Boeing747');
insert into airplanes values('747B','500','Boeing747');
insert into airplanes values('747C','500','Boeing747');
insert into airplanes values('747D','500','Boeing747');
insert into airplanes values('777A','550','Boeing777');
insert into airplanes values('777B','550','Boeing777');
insert into airplanes values('777C','550','Boeing777');
insert into airplanes values('777D','550','Boeing777');
insert into airplanes values('737A','200','Boeing737');
insert into airplanes values('737B','200','Boeing737');
insert into airplanes values('737C','200','Boeing737');
insert into airplanes values('320A','175','AirbusA320');
insert into airplanes values('320B','175','AirbusA320');
insert into airplanes values('380A','11','AirbusA380');
insert into airplanes values('380B','11','AirbusA380');
insert into airplanes values('380C','11','AirbusA380');
insert into airplanes values('MRJA','75','MitsubishiMRJ');
insert into airplanes values('MRJB','75','MitsubishiMRJ');
insert into airplanes values('MRJC','75','MitsubishiMRJ');

insert into legs values('DL2959','1','JFK','07:00:00','DEN','10:00:00');
insert into legs values('DL2959','2','DEN','10:30:00','SFO','12:00:00');
insert into legs values('AAL2771','1','DEN','12:30:00','ORD','15:00:00');
insert into legs values('U7413','1','ILM','16:30:00','ATL','18:00:00');
insert into legs values('BG899','1','HNL','06:30:00','HOU','12:00:00');
insert into legs values('JK554','1','JFK','20:30:00','DCA','22:30:00');
insert into legs values('DC123','1','DCA','04:30:00','JFK','06:30:00');
insert into legs values('HO6969','1','ILM','09:30:00','MIA','12:00:00');
insert into legs values('HO6969','2','MIA','13:00:00','HOU','15:00:00');
insert into legs values('HO6969','3','HOU','17:00:00','HNL','23:00:00');
insert into legs values('YY717','1','SFO','13:00:00','DEN','15:00:00');
insert into legs values('YY717','2','DEN','16:00:00','MIA','19:00:00');
insert into legs values('GO100','1','MIA','07:00:00','DEN','10:00:00');
insert into legs values('GO100','2','DEN','12:00:00','SFO','14:00:00');
insert into legs values('T41CC','1','SFO','13:00:00','DEN','15:00:00');

insert into leginstances values('DL2959','1','2019-06-04','190','737A','JFK','07:00:00','DEN','10:00:00','00:00:00');
insert into leginstances values('DL2959','1','2019-06-06','190','737A','JFK','07:00:00','DEN','10:00:00','00:00:00');
insert into leginstances values('DL2959','2','2019-06-04','190','737B','DEN','10:30:00','SFO','12:00:00','00:00:00');
insert into leginstances values('DL2959','2','2019-06-06','190','737B','DEN','10:30:00','SFO','12:00:00','00:00:00');
insert into leginstances values('AAL2771','1','2019-06-04','1','380A','DEN','12:30:00','ORD','15:00:00','00:00:00');
insert into leginstances values('AAL2771','1','2019-06-08','1','380A','DEN','12:30:00','ORD','15:00:00','00:00:00');
insert into leginstances values('U7413','1','2019-06-04','190','737C','ILM','016:30:00','ATL','18:00:00','00:00:00');
insert into leginstances values('U7413','1','2019-06-08','190','737C','ILM','016:30:00','ATL','18:00:00','00:00:00');
insert into leginstances values('BG899','1','2019-06-06','65','MRJA','HNL','06:30:00','HOU','12:00:00','00:00:00');
insert into leginstances values('BG899','1','2019-06-08','65','MRJA','HNL','06:30:00','HOU','12:00:00','00:00:00');
insert into leginstances values('JK554','1','2019-06-03','490','747B','JFK','20:30:00','DCA','22:30:00','00:00:00');
insert into leginstances values('JK554','1','2019-06-05','490','747B','JFK','20:30:00','DCA','22:30:00','00:00:00');
insert into leginstances values('JK554','1','2019-06-07','490','747B','JFK','20:30:00','DCA','22:30:00','00:00:00');
insert into leginstances values('HO6969','1','2019-06-08','540','777A','ILM','09:30:00','MIA','12:00:00','00:00:00');
insert into leginstances values('HO6969','2','2019-06-08','540','777B','MIA','13:00:00','HOU','15:00:00','00:00:00');
insert into leginstances values('HO6969','3','2019-06-08','540','777B','HOU','17:00:00','HNL','23:00:00','00:00:00');
insert into leginstances values('YY717','1','2019-06-05','165','320A','SFO','13:00:00','DEN','15:00:00','00:00:00');
insert into leginstances values('YY717','2','2019-06-05','165','320A','DEN','16:00:00','MIA','19:00:00','00:00:00');
insert into leginstances values('YY717','1','2019-06-07','165','320A','SFO','13:00:00','DEN','15:00:00','00:00:00');
insert into leginstances values('YY717','2','2019-06-07','165','320A','DEN','16:00:00','MIA','19:00:00','00:00:00');
insert into leginstances values('GO100','1','2019-06-02','165','320B','MIA','07:00:00','DEN','10:00:00','00:00:00');
insert into leginstances values('GO100','2','2019-06-02','165','320B','DEN','12:00:00','SFO','14:00:00','00:00:00');
insert into leginstances values('T41CC','1','2019-06-06','165','320B','SFO','13:00:00','DEN','15:00:00','00:00:00');
insert into leginstances values('T41CC','1','2019-06-08','165','320B','SFO','13:00:00','DEN','15:00:00','00:00:00');
insert into leginstances values('DC123','1','2019-06-04','490','747C','DCA','05:00:00','JFK','07:00:00','00:30:00');
insert into leginstances values('DC123','1','2019-06-06','490','747C','DCA','04:45:00','JFK','06:45:00','00:15:00');
insert into leginstances values('DC123','1','2019-06-08','490','747C','DCA','04:50:00','JFK','06:50:00','00:20:00');


insert into fares values('DL2959', '1', '416', 'none');
insert into fares values('AAL2771', '2', '222', 'non-refundable');
insert into fares values('U7413', '3', '367', 'none');
insert into fares values('BG899', '4', '503', 'non-refundable');
insert into fares values('JK554', '5', '217', 'none');
insert into fares values('DC123', '6', '217', 'none');
insert into fares values('HO6969', '7', '1178', 'non-refundable');
insert into fares values('YY717', '8', '534', 'none');
insert into fares values('GO100', '9', '482', 'non-refundable');
insert into fares values('T41CC', '10', '237', 'none');

insert into canland values('Boeing747','JFK');
insert into canland values('Boeing747','SFO');
insert into canland values('Boeing747','MIA');
insert into canland values('Boeing747','ATL');
insert into canland values('Boeing747','ORD');
insert into canland values('Boeing747','HOU');
insert into canland values('Boeing747','DCA');
insert into canland values('Boeing777','JFK');
insert into canland values('Boeing777','SFO');
insert into canland values('Boeing777','MIA');
insert into canland values('Boeing777','ATL');
insert into canland values('Boeing777','ORD');
insert into canland values('Boeing777','HOU');
insert into canland values('AirbusA380','JFK');
insert into canland values('AirbusA380','SFO');
insert into canland values('AirbusA380','MIA');
insert into canland values('AirbusA380','ATL');
insert into canland values('AirbusA380','ORD');
insert into canland values('Boeing737','JFK');
insert into canland values('Boeing737','SFO');
insert into canland values('Boeing737','MIA');
insert into canland values('Boeing737','ATL');
insert into canland values('Boeing737','ORD');
insert into canland values('Boeing737','HOU');
insert into canland values('Boeing737','ILM');
insert into canland values('Boeing737','DCA');
insert into canland values('Boeing737','DEN');
insert into canland values('AirbusA320','JFK');
insert into canland values('AirbusA320','SFO');
insert into canland values('AirbusA320','MIA');
insert into canland values('AirbusA320','ATL');
insert into canland values('AirbusA320','ORD');
insert into canland values('AirbusA320','HOU');
insert into canland values('AirbusA320','DCA');
insert into canland values('AirbusA320','ILM');
insert into canland values('AirbusA320','DEN');
insert into canland values('MitsubishiMRJ','JFK');
insert into canland values('MitsubishiMRJ','SFO');
insert into canland values('MitsubishiMRJ','MIA');
insert into canland values('MitsubishiMRJ','ATL');
insert into canland values('MitsubishiMRJ','ORD');
insert into canland values('MitsubishiMRJ','HOU');
insert into canland values('MitsubishiMRJ','DCA');
insert into canland values('MitsubishiMRJ','ILM');
insert into canland values('MitsubishiMRJ','DEN');
insert into canland values('MitsubishiMRJ','HNL');

insert into reservations values('DL2959','1','2019-06-04','200','Jack','910-515-0888');
insert into reservations values('DL2959','1','2019-06-06','200','Bill','910-515-6432');
insert into reservations values('DL2959','2','2019-06-04','200','Jack','910-515-0888');
insert into reservations values('DL2959','2','2019-06-06','200','Bill','910-515-6432');
insert into reservations values('AAL2771','1','2019-06-04','11','Sam','504-555-5532');
insert into reservations values('AAL2771','1','2019-06-08','11','Jill','807-513-5599');
insert into reservations values('U7413','1','2019-06-04','200','Jasmine','204-555-6789');
insert into reservations values('U7413','1','2019-06-08','200','Jackie','204-555-6788');
insert into reservations values('BG899','1','2019-06-06','75','Precious','800-545-6668');
insert into reservations values('BG899','1','2019-06-08','75','Bobby','770-585-6688');
insert into reservations values('JK554','1','2019-06-03','500','Brock','563-776-0090');
insert into reservations values('JK554','1','2019-06-05','500','Jenny','111-222-3333');
insert into reservations values('JK554','1','2019-06-07','500','Gertrude','404-565-2984');
insert into reservations values('DC123','1','2019-06-04','500','Bessie','555-778-2291');
insert into reservations values('DC123','1','2019-06-06','500','Tommy','336-151-0054');
insert into reservations values('DC123','1','2019-06-08','500','Seven','888-123-1465');
insert into reservations values('HO6969','1','2019-06-08','550','Daniel','509-226-9926');
insert into reservations values('HO6969','2','2019-06-08','550','Daniel','509-226-9926');
insert into reservations values('HO6969','3','2019-06-08','550','Daniel','509-226-9926');
insert into reservations values('YY717','1','2019-06-05','175','Beyonce','404-954-4594');
insert into reservations values('YY717','2','2019-06-05','175','Beyonce','404-954-4594');
insert into reservations values('YY717','1','2019-06-07','175','Jay-Z','404-954-4596');
insert into reservations values('YY717','2','2019-06-07','175','Jay-Z','404-954-4596');
insert into reservations values('GO100','1','2019-06-02','175','MarkyMark','100-100-8008');
insert into reservations values('GO100','2','2019-06-02','175','MarkyMark','100-100-8008');
insert into reservations values('T41CC','1','2019-06-06','175','Peggy','898-222-8998');
insert into reservations values('T41CC','1','2019-06-08','175','Hank','898-222-8996');

insert into reservations values('DL2959','1','2019-06-04','199','Braxton','359-452-9514');
insert into reservations values('DL2959','1','2019-06-06','199','Mae','456-987-3578');
insert into reservations values('DL2959','2','2019-06-04','199','Braxton','359-452-9514');
insert into reservations values('DL2959','2','2019-06-06','199','Mae','456-987-3578');
insert into reservations values('AAL2771','1','2019-06-04','10','Johanna','745-412-5236');
insert into reservations values('AAL2771','1','2019-06-08','10','Carla','965-632-5214');
insert into reservations values('U7413','1','2019-06-04','199','Marianna','478-856-3179');
insert into reservations values('U7413','1','2019-06-08','199','Sumaya','666-789-7423');
insert into reservations values('BG899','1','2019-06-06','74','Ebony','812-832-8132');
insert into reservations values('BG899','1','2019-06-08','74','Joey','910-951-7538');
insert into reservations values('JK554','1','2019-06-03','499','Aayush','563-776-0090');
insert into reservations values('JK554','1','2019-06-05','499','Haley','789-999-1111');
insert into reservations values('JK554','1','2019-06-07','499','Patrik','378-916-4863');
insert into reservations values('DC123','1','2019-06-04','499','Pheobe','625-845-1959');
insert into reservations values('DC123','1','2019-06-06','499','Hebe','375-358-3248');
insert into reservations values('DC123','1','2019-06-08','499','Anna','742-635-8598');
insert into reservations values('HO6969','1','2019-06-08','549','Velma','941-843-7632');
insert into reservations values('HO6969','2','2019-06-08','549','Velma','941-843-7632');
insert into reservations values('HO6969','3','2019-06-08','549','Velma','941-843-7632');
insert into reservations values('YY717','1','2019-06-05','174','Cory','248-268-1793');
insert into reservations values('YY717','2','2019-06-05','174','Cory','248-268-1793');
insert into reservations values('YY717','1','2019-06-07','174','Dane','551-489-3269');
insert into reservations values('YY717','2','2019-06-07','174','Dane','551-489-3269');
insert into reservations values('GO100','1','2019-06-02','174','Abdur','333-555-8888');
insert into reservations values('GO100','2','2019-06-02','174','Abdur','333-555-8888');
insert into reservations values('T41CC','1','2019-06-06','174','Tallulah','225-589-5635');
insert into reservations values('T41CC','1','2019-06-08','174','Kohen','823-614-8989');

insert into reservations values('DL2959','1','2019-06-04','198','Martyn','910-515-0888');
insert into reservations values('DL2959','1','2019-06-06','198','Patience','910-515-6432');
insert into reservations values('DL2959','2','2019-06-04','198','Martyn','910-515-0888');
insert into reservations values('DL2959','2','2019-06-06','198','Patience','910-515-6432');
insert into reservations values('AAL2771','1','2019-06-04','9','Abbas','504-555-5532');
insert into reservations values('AAL2771','1','2019-06-08','9','Oisin','807-513-5599');
insert into reservations values('U7413','1','2019-06-04','198','Tahmid','204-555-6789');
insert into reservations values('U7413','1','2019-06-08','198','Amelia','204-555-6788');
insert into reservations values('BG899','1','2019-06-06','73','Natalia','800-545-6668');
insert into reservations values('BG899','1','2019-06-08','73','Rajan','770-585-6688');
insert into reservations values('JK554','1','2019-06-03','498','Annette','563-776-0090');
insert into reservations values('JK554','1','2019-06-05','498','Bonnie','111-222-3333');
insert into reservations values('JK554','1','2019-06-07','498','Karim','404-565-2984');
insert into reservations values('DC123','1','2019-06-04','498','Maxine','555-778-2291');
insert into reservations values('DC123','1','2019-06-06','498','Shania','336-151-0054');
insert into reservations values('DC123','1','2019-06-08','498','Fariha','888-123-1465');
insert into reservations values('HO6969','1','2019-06-08','548','Keyaan','509-226-9926');
insert into reservations values('HO6969','2','2019-06-08','548','Keyaan','509-226-9926');
insert into reservations values('HO6969','3','2019-06-08','548','Keyaan','509-226-9926');
insert into reservations values('YY717','1','2019-06-05','173','Arya','404-954-4594');
insert into reservations values('YY717','2','2019-06-05','173','Arya','404-954-4594');
insert into reservations values('YY717','1','2019-06-07','173','Gracie','404-954-4596');
insert into reservations values('YY717','2','2019-06-07','173','Gracie','404-954-4596');
insert into reservations values('GO100','1','2019-06-02','173','Eduard','100-100-8008');
insert into reservations values('GO100','2','2019-06-02','173','Eduard','100-100-8008');
insert into reservations values('T41CC','1','2019-06-06','173','Alayah','898-222-8998');
insert into reservations values('T41CC','1','2019-06-08','173','Alara','898-222-8996');

insert into reservations values('DL2959','1','2019-06-04','197','Karla','214-528-4374');
insert into reservations values('DL2959','1','2019-06-06','197','Shreya','626-430-9135');
insert into reservations values('DL2959','2','2019-06-04','197','Karla','214-528-4374');
insert into reservations values('DL2959','2','2019-06-06','197','Shreya','626-430-9135');
insert into reservations values('AAL2771','1','2019-06-04','8','Keiron','269-229-7221');
insert into reservations values('AAL2771','1','2019-06-08','8','Zunairah','305-302-9270');
insert into reservations values('U7413','1','2019-06-04','197','Cody','440-508-8391');
insert into reservations values('U7413','1','2019-06-08','197','Wasim','812-640-4478');
insert into reservations values('BG899','1','2019-06-06','72','Juno','203-622-2668');
insert into reservations values('BG899','1','2019-06-08','72','June','763-789-0960');
insert into reservations values('JK554','1','2019-06-03','497','Vikram','760-752-8983');
insert into reservations values('JK554','1','2019-06-05','497','Julie','404-915-0989');
insert into reservations values('JK554','1','2019-06-07','497','Sarina','440-301-9812');
insert into reservations values('DC123','1','2019-06-04','497','Harlow','941-359-1468');
insert into reservations values('DC123','1','2019-06-06','497','Yousif','251-368-5686');
insert into reservations values('DC123','1','2019-06-08','497','Dollie','618-996-5949');
insert into reservations values('HO6969','1','2019-06-08','547','Augustus','914-366-2613');
insert into reservations values('HO6969','2','2019-06-08','547','Augustus','914-366-2613');
insert into reservations values('HO6969','3','2019-06-08','547','Augustus','914-366-2613');
insert into reservations values('YY717','1','2019-06-05','172','Betsy','212-328-7209');
insert into reservations values('YY717','2','2019-06-05','172','Betsy','212-328-7209');
insert into reservations values('YY717','1','2019-06-07','172','Kyla','205-513-8134');
insert into reservations values('YY717','2','2019-06-07','172','Kyla','205-513-8134');
insert into reservations values('GO100','1','2019-06-02','172','Lola','701-253-7976');
insert into reservations values('GO100','2','2019-06-02','172','Lola','701-253-7976');
insert into reservations values('T41CC','1','2019-06-06','172','Rose','641-329-6995');
insert into reservations values('T41CC','1','2019-06-08','172','Mica','714-769-2108');

insert into reservations values('DL2959','1','2019-06-04','196','Liliana','806-283-6851');
insert into reservations values('DL2959','1','2019-06-06','196','Kareena','248-205-2553');
insert into reservations values('DL2959','2','2019-06-04','196','Liliana','806-283-6851');
insert into reservations values('DL2959','2','2019-06-06','196','Kareena','248-205-2553');
insert into reservations values('AAL2771','1','2019-06-04','7','Ellie','817-200-9984');
insert into reservations values('AAL2771','1','2019-06-08','7','Kiana','970-920-4626');
insert into reservations values('U7413','1','2019-06-04','196','Callan','573-241-6791');
insert into reservations values('U7413','1','2019-06-08','196','Zhane','516-233-1278');
insert into reservations values('BG899','1','2019-06-06','71','Marcos','804-840-3730');
insert into reservations values('BG899','1','2019-06-08','71','Kathy','419-752-1072');
insert into reservations values('JK554','1','2019-06-03','496','Arfa','225-278-3365');
insert into reservations values('JK554','1','2019-06-05','496','Arnold','503-921-2485');
insert into reservations values('JK554','1','2019-06-07','496','Reem','707-319-0551');
insert into reservations values('DC123','1','2019-06-04','496','Reek','715-635-5871');
insert into reservations values('DC123','1','2019-06-06','496','Tyrion','646-515-9535');
insert into reservations values('DC123','1','2019-06-08','496','Cersei','806-463-1291');
insert into reservations values('HO6969','1','2019-06-08','546','Zahara','847-389-6286');
insert into reservations values('HO6969','2','2019-06-08','546','Zahara','847-389-6286');
insert into reservations values('HO6969','3','2019-06-08','546','Zahara','847-389-6286');
insert into reservations values('YY717','1','2019-06-05','171','Jamie','920-865-2372');
insert into reservations values('YY717','2','2019-06-05','171','Jamie','920-865-2372');
insert into reservations values('YY717','1','2019-06-07','171','Archie','231-745-1615');
insert into reservations values('YY717','2','2019-06-07','171','Archie','231-745-1615');
insert into reservations values('GO100','1','2019-06-02','171','Alina','770-899-8000');
insert into reservations values('GO100','2','2019-06-02','171','Alina','770-899-8000');
insert into reservations values('T41CC','1','2019-06-06','171','Shannon','864-515-5121');
insert into reservations values('T41CC','1','2019-06-08','171','Borys','757-881-9244');

insert into reservations values('DL2959','1','2019-06-04','195','Carole','712-327-7400');
insert into reservations values('DL2959','1','2019-06-06','195','Jaylan','907-733-7961');
insert into reservations values('DL2959','2','2019-06-04','195','Carole','712-327-7400');
insert into reservations values('DL2959','2','2019-06-06','195','Jaylan','907-733-7961');
insert into reservations values('AAL2771','1','2019-06-04','6','Ellouise','919-788-0515');
insert into reservations values('AAL2771','1','2019-06-08','6','Allegra','415-652-1685');
insert into reservations values('U7413','1','2019-06-04','195','Denzel','484-707-6306');
insert into reservations values('U7413','1','2019-06-08','195','Jensen','845-555-3291');
insert into reservations values('BG899','1','2019-06-06','70','Harold','312-645-3107');
insert into reservations values('BG899','1','2019-06-08','70','Lillie','650-365-1942');
insert into reservations values('JK554','1','2019-06-03','495','Milo','662-693-2532');
insert into reservations values('JK554','1','2019-06-05','495','Belinda','217-497-1798');
insert into reservations values('JK554','1','2019-06-07','495','Collette','202-872-2423');
insert into reservations values('DC123','1','2019-06-04','495','Arissa','512-582-7604');
insert into reservations values('DC123','1','2019-06-06','495','Codie','410-583-6461');
insert into reservations values('DC123','1','2019-06-08','495','Cecily','507-494-1174');
insert into reservations values('HO6969','1','2019-06-08','545','Tanner','936-591-7867');
insert into reservations values('HO6969','2','2019-06-08','545','Tanner','936-591-7867');
insert into reservations values('HO6969','3','2019-06-08','545','Tanner','936-591-7867');
insert into reservations values('YY717','1','2019-06-05','170','Simra','928-765-6696');
insert into reservations values('YY717','2','2019-06-05','170','Simra','928-765-6696');
insert into reservations values('YY717','1','2019-06-07','170','Danyaal','561-358-6102');
insert into reservations values('YY717','2','2019-06-07','170','Danyaal','561-358-6102');
insert into reservations values('GO100','1','2019-06-02','170','Teresa','312-599-6248');
insert into reservations values('GO100','2','2019-06-02','170','Teresa','312-599-6248');
insert into reservations values('T41CC','1','2019-06-06','170','Alaw','971-555-4977');
insert into reservations values('T41CC','1','2019-06-08','170','Abu','708-757-9018');

insert into reservations values('DL2959','1','2019-06-04','194','Izzy','413-784-2920');
insert into reservations values('DL2959','1','2019-06-06','194','Brittany','413-784-2920');
insert into reservations values('DL2959','2','2019-06-04','194','Izzy','413-784-2920');
insert into reservations values('DL2959','2','2019-06-06','194','Brittany','413-784-2920');
insert into reservations values('AAL2771','1','2019-06-04','5','Haaris','408-734-6734');
insert into reservations values('AAL2771','1','2019-06-08','5','Alyce','320-356-4986');
insert into reservations values('U7413','1','2019-06-04','194','Gilbert','573-674-6849');
insert into reservations values('U7413','1','2019-06-08','194','Fiona','773-688-5904');
insert into reservations values('BG899','1','2019-06-06','69','Constance','309-344-9691');
insert into reservations values('BG899','1','2019-06-08','69','Aishah','949-754-7070');
insert into reservations values('JK554','1','2019-06-03','494','Damian','503-993-2753');
insert into reservations values('JK554','1','2019-06-05','494','Lukas','316-670-0026');
insert into reservations values('JK554','1','2019-06-07','494','Clyde','903-586-9705');
insert into reservations values('DC123','1','2019-06-04','494','Eryk','802-872-2475');
insert into reservations values('DC123','1','2019-06-06','494','Paisley','251-525-0417');
insert into reservations values('DC123','1','2019-06-08','494','Shyam','208-475-8378');
insert into reservations values('HO6969','1','2019-06-08','544','Humayra','712-944-6378');
insert into reservations values('HO6969','2','2019-06-08','544','Humayra','712-944-6378');
insert into reservations values('HO6969','3','2019-06-08','544','Humayra','712-944-6378');
insert into reservations values('YY717','1','2019-06-05','169','Dana','405-681-8054');
insert into reservations values('YY717','2','2019-06-05','169','Dana','405-681-8054');
insert into reservations values('YY717','1','2019-06-07','169','Gail','845-431-8943');
insert into reservations values('YY717','2','2019-06-07','169','Gail','845-431-8943');
insert into reservations values('GO100','1','2019-06-02','169','Danika','323-347-3276');
insert into reservations values('GO100','2','2019-06-02','169','Danika','323-347-3276');
insert into reservations values('T41CC','1','2019-06-06','169','Cadi','845-429-9066');
insert into reservations values('T41CC','1','2019-06-08','169','Steven','352-362-2559');

insert into reservations values('DL2959','1','2019-06-04','193','Kennedy','724-914-3324');
insert into reservations values('DL2959','1','2019-06-06','193','Rochelle','765-589-9525');
insert into reservations values('DL2959','2','2019-06-04','193','Kennedy','724-914-3324');
insert into reservations values('DL2959','2','2019-06-06','193','Rochelle','765-589-9525');
insert into reservations values('AAL2771','1','2019-06-04','4','Klara','517-416-0507');
insert into reservations values('AAL2771','1','2019-06-08','4','Francesca','603-947-7549');
insert into reservations values('U7413','1','2019-06-04','193','Stanislaw','316-284-8356');
insert into reservations values('U7413','1','2019-06-08','193','Ahyan','574-878-1652');
insert into reservations values('BG899','1','2019-06-06','68','Manon','440-572-8978');
insert into reservations values('BG899','1','2019-06-08','68','Jovan','816-529-5742');
insert into reservations values('JK554','1','2019-06-03','493','Tayyab','712-829-1704');
insert into reservations values('JK554','1','2019-06-05','493','Lana','602-665-1039');
insert into reservations values('JK554','1','2019-06-07','493','Benedict','936-216-8353');
insert into reservations values('DC123','1','2019-06-04','493','Sahib','413-536-8823');
insert into reservations values('DC123','1','2019-06-06','493','Adam','772-215-9532');
insert into reservations values('DC123','1','2019-06-08','493','Maureen','903-468-1924');
insert into reservations values('HO6969','1','2019-06-08','543','Ali','330-241-1838');
insert into reservations values('HO6969','2','2019-06-08','543','Ali','330-241-1838');
insert into reservations values('HO6969','3','2019-06-08','543','Ali','330-241-1838');
insert into reservations values('YY717','1','2019-06-05','168','Kenan','518-629-9693');
insert into reservations values('YY717','2','2019-06-05','168','Kenan','518-629-9693');
insert into reservations values('YY717','1','2019-06-07','168','Menna','231-325-0457');
insert into reservations values('YY717','2','2019-06-07','168','Menna','231-325-0457');
insert into reservations values('GO100','1','2019-06-02','168','Cali','831-525-6916');
insert into reservations values('GO100','2','2019-06-02','168','Cali','831-525-6916');
insert into reservations values('T41CC','1','2019-06-06','168','Scarlett','603-883-6472');
insert into reservations values('T41CC','1','2019-06-08','168','Dominic','213-610-2298');

insert into reservations values('DL2959','1','2019-06-04','192','Kimberly','304-331-0995');
insert into reservations values('DL2959','1','2019-06-06','192','Morwenna','518-835-4117');
insert into reservations values('DL2959','2','2019-06-04','192','Kimberly','304-331-0995');
insert into reservations values('DL2959','2','2019-06-06','192','Morwenna','518-835-4117');
insert into reservations values('AAL2771','1','2019-06-04','3','Taha','267-224-8734');
insert into reservations values('AAL2771','1','2019-06-08','3','Lawson','850-769-0670');
insert into reservations values('U7413','1','2019-06-04','192','Theodore','248-275-8412');
insert into reservations values('U7413','1','2019-06-08','192','Nayla','702-362-4255');
insert into reservations values('BG899','1','2019-06-06','67','Hilda','413-825-3232');
insert into reservations values('BG899','1','2019-06-08','67','Adrienne','580-539-1378');
insert into reservations values('JK554','1','2019-06-03','492','Donald','678-588-5179');
insert into reservations values('JK554','1','2019-06-05','492','Ned','701-673-7300');
insert into reservations values('JK554','1','2019-06-07','492','Noel','252-939-5165');
insert into reservations values('DC123','1','2019-06-04','492','Kate','305-479-0388');
insert into reservations values('DC123','1','2019-06-06','492','Eoghan','281-443-0704');
insert into reservations values('DC123','1','2019-06-08','492','Paddy','864-845-3354');
insert into reservations values('HO6969','1','2019-06-08','542','Kadie','316-619-2428');
insert into reservations values('HO6969','2','2019-06-08','542','Kadie','316-619-2428');
insert into reservations values('HO6969','3','2019-06-08','542','Kadie','316-619-2428');
insert into reservations values('YY717','1','2019-06-05','167','Saeed','540-559-5474');
insert into reservations values('YY717','2','2019-06-05','167','Saeed','540-559-5474');
insert into reservations values('YY717','1','2019-06-07','167','Nathan','603-335-8069');
insert into reservations values('YY717','2','2019-06-07','167','Nathan','603-335-8069');
insert into reservations values('GO100','1','2019-06-02','167','Riyad','309-999-1637');
insert into reservations values('GO100','2','2019-06-02','167','Riyad','309-999-1637');
insert into reservations values('T41CC','1','2019-06-06','167','Abbigail','989-665-4630');
insert into reservations values('T41CC','1','2019-06-08','167','Kaison','630-448-2949');

insert into reservations values('DL2959','1','2019-06-04','191','Riley','410-737-7534');
insert into reservations values('DL2959','1','2019-06-06','191','Asa','618-433-0857');
insert into reservations values('DL2959','2','2019-06-04','191','Riley','410-737-7534');
insert into reservations values('DL2959','2','2019-06-06','191','Asa','618-433-0857');
insert into reservations values('AAL2771','1','2019-06-04','2','Jenna','413-474-2760');
insert into reservations values('AAL2771','1','2019-06-08','2','Leona','202-332-9295');
insert into reservations values('U7413','1','2019-06-04','191','Vernon','317-724-0644');
insert into reservations values('U7413','1','2019-06-08','191','Nataniel','317-536-1716');
insert into reservations values('BG899','1','2019-06-06','66','Lillie','706-799-9096');
insert into reservations values('BG899','1','2019-06-08','66','Tayyib','606-422-5562');
insert into reservations values('JK554','1','2019-06-03','491','Eisa','503-426-1295');
insert into reservations values('JK554','1','2019-06-05','491','Evelina','413-631-2000');
insert into reservations values('JK554','1','2019-06-07','491','Adaline','727-389-0176');
insert into reservations values('DC123','1','2019-06-04','491','Sameer','804-494-6418');
insert into reservations values('DC123','1','2019-06-06','491','Debra','312-299-9676');
insert into reservations values('DC123','1','2019-06-08','491','Theodor','504-244-4362');
insert into reservations values('HO6969','1','2019-06-08','541','Hasan','218-695-6749');
insert into reservations values('HO6969','2','2019-06-08','541','Hasan','218-695-6749');
insert into reservations values('HO6969','3','2019-06-08','541','Hasan','218-695-6749');
insert into reservations values('YY717','1','2019-06-05','166','Emrys','407-324-8134');
insert into reservations values('YY717','2','2019-06-05','166','Emrys','407-324-8134');
insert into reservations values('YY717','1','2019-06-07','166','Esha','303-430-1314');
insert into reservations values('YY717','2','2019-06-07','166','Esha','303-430-1314');
insert into reservations values('GO100','1','2019-06-02','166','Valentino','646-778-0055');
insert into reservations values('GO100','2','2019-06-02','166','Valentino','646-778-0055');
insert into reservations values('T41CC','1','2019-06-06','166','Cooper','734-845-6401');
insert into reservations values('T41CC','1','2019-06-08','166','Franco','734-845-6401');


insert into views values('Bob','6f086429a8bc497453037c6f5e3e804b','airportManager','all');
insert into views values('Lisa','2012a79c941ccb71d03283d306989116','ticketAgent','customer');
insert into views values('Janet','a4d8498b01a8f4360d3cfed9ba533881','flightAdmin','admin');