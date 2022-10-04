<<<<<<< HEAD
    ﻿Drop DATABASE ETransportationManagement
=======
>>>>>>> 1482f69fe6ef2f41a912323d7a19adab9975a282
CREATE DATABASE ETransportationManagement
use ETransportationManagement

CREATE TABLE tblRoles(
    RoleID char(5) PRIMARY KEY,
    RoleName nvarchar(100)
)

CREATE TABLE tblUsers (
    UserID nvarchar(100) PRIMARY KEY,
    Username nvarchar(200) NOT NULL UNIQUE,
    [Password] nvarchar(200) NOT NULL,
    Email nvarchar(100) NOT NULL,
    DOB date, 
    [Address] nvarchar(300),
    PhoneNumber char(11), 
    Sex bit,
    RoleID char(5) FOREIGN KEY REFERENCES tblRoles(RoleID) ON UPDATE CASCADE ON DELETE SET NULL,
    AccountBalance decimal DEFAULT 0,
    [Status] int DEFAULT 1
) 

CREATE TABLE tblOrders(
    OrderID char(5) PRIMARY KEY,
    CreateDate DATETIME DEFAULT GETDATE(),
    PaymentMode nvarchar(100),
    UserID nvarchar(100) FOREIGN KEY REFERENCES tblUsers(UserID) ON UPDATE CASCADE ON DELETE SET NULL,
    [Status] BIT DEFAULT 0
)

CREATE TABLE tblCities(
    CityID INT IDENTITY PRIMARY KEY,
    CityName nvarchar(100) UNIQUE
)

CREATE TABLE tblLocations(
    LocationID INT IDENTITY PRIMARY KEY,
    LocationName nvarchar(100),
    Address nvarchar(100),
    CityID INT FOREIGN KEY REFERENCES tblCities(CityID),
    [Status] BIT DEFAULT 0
)
CREATE TABLE tblRoutes(
    RouteID INT IDENTITY PRIMARY KEY,
    RouteName nvarchar(100),
    StartLocation INT FOREIGN KEY REFERENCES tblLocations(LocationID),
    EndLocation INT FOREIGN KEY REFERENCES tblLocations(LocationID),
    [Description] nvarchar(1000),
    [Status] BIT DEFAULT 1
)

CREATE TABLE tblVehicleTypes(
    VehicleTypeID INT IDENTITY PRIMARY KEY,
    VehicleTypeName nvarchar(100),
    TotalSeat INT NOT NULL
)

CREATE TABLE tblVehicles(
    VehicleID char(5) PRIMARY KEY,
    VehicleName nvarchar(100),
    LicensePlate nvarchar(20),
    VehicleTypeID INT FOREIGN KEY REFERENCES tblVehicleTypes(VehicleTypeID) ON UPDATE CASCADE ON DELETE SET NULL,
    [Status] INT DEFAULT 1,
)
CREATE TABLE tblDrivers(
    DriverID char(12) PRIMARY KEY,
    DriverName nvarchar(150) NOT NULL,
    DOB DATE, 
    Sex BIT,
    DriverPic nvarchar(300) NOT NULL,
    PhoneNumber char(11),
    [Status] INT DEFAULT 1
)

CREATE TABLE tblDriverLicenses(
    DriverLicenseID char(12) PRIMARY KEY,
    Nationality nvarchar(100),
    Class char(2) NOT NULL,
    DateExpired DATE,
    DriverID char(12) FOREIGN KEY REFERENCES tblDrivers(DriverID) ON UPDATE CASCADE ON DELETE SET NULL
)

CREATE TABLE tblTrips(
    TripID char(5) NOT NULL PRIMARY KEY,
    TripName nvarchar(100),
    StartDateTime DATETIME NOT NULL,
    [Policy] nvarchar(2000),
    RouteID INT FOREIGN KEY REFERENCES tblRoutes(RouteID) ON UPDATE CASCADE ON DELETE SET NULL,
    VehicleID char(5) FOREIGN KEY REFERENCES tblVehicles(VehicleID) ON UPDATE CASCADE ON DELETE SET NULL,
    DriverID char(12) FOREIGN KEY REFERENCES tblDrivers(DriverID) ON UPDATE CASCADE ON DELETE SET NULL,
    SeatRemain INT,
    [Status] INT NOT NULL DEFAULT 1	
)

CREATE TABLE tblSeats(
    SeatID Char(5) NOT NULL,
    Price Decimal,
    [Status] BIT DEFAULT 1,
    TripID char(5) FOREIGN KEY REFERENCES tblTrips(TripID),
    PRIMARY KEY (SeatID,TripID) 
)

CREATE TABLE tblTickets(
    TicketID INT IDENTITY PRIMARY KEY,
    SeatID char(5) NOT NULL,
    TripID char(5) NOT NULL, 
    OrderID char(5) FOREIGN KEY REFERENCES tblOrders(OrderID) ON UPDATE CASCADE ON DELETE SET NULL
)
ALTER TABLE tblTickets
ADD CONSTRAINT FK_TblTickets_TblSeat FOREIGN KEY (SeatID, TripID) REFERENCES tblSeats(SeatID, TripID)

INSERT INTO tblRoles(RoleID,RoleName) VALUES (1,'User')
INSERT INTO tblRoles(RoleID,RoleName) VALUES (2,'Staff')
INSERT INTO tblRoles(RoleID,RoleName) VALUES (3,'Admin')

INSERT INTO tblUsers(UserID,Username,[Password],Email,DOB,[Address],PhoneNumber,Sex,RoleID,AccountBalance,[Status]) 
VALUES ('nangchoichang',N'Trần Quang Đại','123','quangdai@gmail.com','1996-06-12',N'48 Lũy Bán Bích, Bình Tân, HCM','0912345678',1,1,300000,1)
INSERT INTO tblUsers(UserID,Username,[Password],Email,DOB,[Address],PhoneNumber,Sex,RoleID,AccountBalance,[Status]) 
VALUES ('coanhcho',N'Lê Văn Minh','123','vanminh@gmail.com','1998-09-11',N'56 Tân Hòa Đông, Bình Tân, HCM','0912345679',1,1,400000,1)
INSERT INTO tblUsers(UserID,Username,[Password],Email,DOB,[Address],PhoneNumber,Sex,RoleID,AccountBalance,[Status]) 
VALUES ('buoncuatoi',N'Tô Thi Lý','123','toly@gmail.com','1996-06-22','48 Lũy Bán Bích, Bình Tân, HCM','0912345678',0,1,450000,1)
INSERT INTO tblUsers(UserID,Username,[Password],Email,DOB,[Address],PhoneNumber,Sex,RoleID,AccountBalance,[Status]) 
VALUES ('conangbian',N'Lê Ngọc Diệp','123','bian@gmail.com','1996-06-15',N'48 Lũy Bán Bích, Bình Tân, HCM','0912345678',0,2,0,1)
INSERT INTO tblUsers(UserID,Username,[Password],Email,DOB,[Address],PhoneNumber,Sex,RoleID,AccountBalance,[Status]) 
VALUES ('admin',N'Lê Đức Minh','admin','ducminh@gmail.com','1996-07-13',N'48 Lũy Bán Bích, Bình Tân, HCM','0912345678',1,3,0,1)

INSERT INTO tblLocations ([LocationName],[Address],[CityID],[Status]) VALUES
	 (N'Đắk Lắk',N'172 Lê Duẩn, TP Buôn Ma Thuột, Đắk Lắk',16,1),
	 (N'Đắk Nông',N'226 Hai Bà Trưng, Nghĩa Thành, Gia Nghĩa, Đắk Nông',17,1),
	 (N'CHÂU ĐỐC',N'89 Phan Văn Vàng , P.Châu Phú B, TP.Châu Đốc, An Giang',1,1),
	 (N'BẠC LIÊU',N'QL1A, Khóm 2, P.7, TP.Bạc Liêu, Bạc Liêu',5,1),
	 (N'BẾN TRE',N'Đường Võ Nguyên Giáp, Quốc lộ 60, xã Sơn Đông, Tp. Bến Tre, Tỉnh Bến Tre',7,1),
	 (N'CÀ MAU',N'309 Lý Thường Kiệt, P.6, TP.Cà Mau, Cà Mau',12,1),
	 (N'NĂM CĂN',N'Khóm Cái Nai, TT.Năm Căn, H.Năm Căn, Cà Mau (BX Năm Căn)',12,1),
	 (N'HỘ PHÒNG',N'Kênh 6 QL 1A, Ấp 1, Ngã 3 Giá Ray, Bạc Liêu',5,1),
	 (N'91B',N'91B Nguyễn Văn Linh, P.Hưng Lợi, Q.Ninh Kiều, TP.Cần Thơ (BX 91B Cần Thơ)',13,1),
	 (N'Ô MÔN',N'QL91, P.Châu Văn Liêm, Q.Ô Môn, TP.Cần Thơ (BX Ô Môn)',13,1);
INSERT INTO tblLocations ([LocationName],[Address],[CityID],[Status]) VALUES
	 (N'CAO LÃNH',N'17-19 Võ Thị Sáu, P.2, TP.Cao Lãnh, Đồng Tháp',20,1),
	 (N'VỊNH TRE',N'Xã Vĩnh Thạnh Trung, TT.Cái Dầu, H.Châu Phú, An Giang',1,1),
	 (N'BX MỚI CHÂU ĐỐC',N'QL 91, Tôn Đức Thắng, P.Vĩnh Mỹ, TP.Châu Đốc, An Giang (BX Mới Châu Đốc)',1,1),
	 (N'CHỢ RẪY',N'20 Phạm Hữu Chí, Phường 11, Quận 5, Thành phố Hồ Chí Minh',58,1),
	 (N'ĐÀ LẠT',N'01 Tô Hiến Thành, P.6, TP.Đà Lạt, Lâm Đồng',35,1),
	 (N'ĐỨC TRỌNG',N'695-697, QL20 Liên Nghĩa, H.Đức Trọng, Lâm Đồng',35,1),
	 (N'DI LINH',N'735 Hùng Vương, TT.Di Linh, H.Di Linh, Lâm Đồng',35,1),
	 (N'BẢO LỘC',N'280 Trần Phú, TX.Bảo Lộc, Lâm Đồng',35,1),
	 (N'HÀ TIÊN',N'QL80, KP 5, P.Bình San, TX.Hà Tiên, Kiên Giang (BX Hà Tiên)',32,1),
	 (N'KIÊN LƯƠNG',N'397 QL 80, KP Ngã ba, TT.Kiên Lương, H.Kiên Lương, Kiên Giang',32,1);
INSERT INTO tblLocations ([LocationName],[Address],[CityID],[Status]) VALUES
	 (N'BA HÒN',N'QL 80, Tổ 3, KP Kiên Tân, TT.Kiên Lương, H.Kiên Lương, Kiên Giang',32,1),
	 (N'NGÃ 7 PHỤNG HIỆP',N'BX Ngã 7, P.Ngã Bảy, TX.Ngã Bảy, Hậu Giang',28,1),
	 (N'HỒNG NGỰ',N'Ngã 4 Võ Văn Kiệt - Điện Biên Phủ, P.Thanh An, TX.Hồng Ngự, Đồng Tháp',20,1),
	 (N'LÂM ĐỒNG',N'795 - QL20 - TT Liên Nghĩa - Huyện Đức Trọng - Lâm Đồng',35,1),
	 (N'BÌNH HÒA',N'QL91, X.Bình Hòa, H.Châu Thành, An Giang',1,1),
	 (N'LONG XUYÊN',N'99 Hàm Nghi, P. Bình Khánh, TP.Long Xuyên, An Giang',1,1),
	 (N'VÀM CỐNG',N'Bến Phà Vàm Cống,  TP.Long Xuyên, An Giang',1,1),
	 (N'LỘ TẺ TRI TÔN',N'Ngã 3 Lộ Tẻ Tri Tôn, X.Bình Hòa, H.Châu Thành, An Giang',1,1),
	 (N'PHÚ HÒA',N'Âp Phú Hữu, TT.Phú Hòa, H.Thoại Sơn, An Giang',1,1),
	 (N'AN HÒA',N'19-20X Lý Thái Tổ, P.Mỹ Long, TP.Long Xuyên (cách cổng phà An Hòa 50m)',1,1);
INSERT INTO tblLocations ([LocationName],[Address],[CityID],[Status]) VALUES
	 (N'NGUYỄN CƯ TRINH',N'26 Nguyễn Cư Trinh, Phường Phạm Ngũ Lão, Quận 1',58,1),
	 (N'BX PHÍA NAM',N'64 Trần Quý Cáp, TP.Phan Thiết, Bình Thuận',11,1),
	 (N'BX PHÍA BẮC',N'01 Từ Văn Tư, TP.Phan Thiết, Bình Thuận',11,1),
	 (N'PHAN THIẾT',N'121 Tôn Đức Thắng, TP.Phan Thiết, Bình Thuận',11,1),
	 (N'MŨI NÉ',N'20 Huỳnh Thức Kháng, P.Hàm Tiến, TP.Phan Thiết, Bình Thuận',11,1),
	 (N'VP 326 ĐƯỜNG 19/04',N'326 Đường 19/04, P.Xuân An, TP.Phan Thiết, Bình Thuận',11,1),
	 (N'RẠCH SỎI',N'12 Mai Thị Hồng Hạnh, KP3, P.Rạch Sỏi, TP.Kiên Giang, Kiên Giang (BX Rạch Sỏi)',32,1),
	 (N'RẠCH GIÁ',N'260A Nguyễn Bỉnh Khiêm, P.Vĩnh Quang, TP.Rạch Giá, Kiên Giang (BX Rạch Giá)',32,1),
	 (N'LẠC HỒNG',N'67-69 Lạc Hồng, P.Vĩnh Lạc, TP.Rạch Giá, Kiên Giang',32,1),
	 (N'TÂN HIỆP',N'137-139 Ấp Đông Hưng, TT.Tân Hiệp, H.Tân Hiệp, Kiên Giang',32,1);
INSERT INTO tblLocations ([LocationName],[Address],[CityID],[Status]) VALUES
	 (N'SA ĐÉC',N'149/8 Khóm Hòa Khánh, P.2, TP.Sa Đéc, Đồng Tháp',20,1),
	 (N'LAI VUNG',N'137A QL80, X.Hòa Long, H.Lai Vung, Đồng Tháp',20,1),
	 (N'LẤP VÒ',N'135 đường 3/2, Ấp Bình Thạnh 1, TT.Lấp Vò, H.Lấp Vò, Đồng Tháp',20,1),
	 (N'CÁI TÀU HẠ',N'QL80, Khóm Phú Mỹ Hiệp, TT.Cái Tàu Hạ, H.Châu Thành, Đồng Tháp',20,1),
	 (N'SÀI GÒN',N'9 Đặng Thái Thân, Phường 11, Quận 5, Thành phố Hồ Chí Minh',58,1),
	 (N'SÀI GÒN',N'68 Nơ Trang Long, Phường 14, Quận Bình Thạnh, Thành phố Hồ Chí Minh',58,1),
	 (N'SÓC TRĂNG',N'38 Lê Duẩn, P.3, TP.Sóc Trăng, Sóc Trăng',50,1),
	 (N'An Trạch',N'720 QL 1A, Ấp An Trạch, X.An Hiêp, H.Châu Thành, Sóc Trăng',50,1),
	 (N'ĐỒNG TÂM',N'Ngã 4 Đồng Tâm, Ấp 4, X.Tam Hiệp, H.Châu Thành, Tiền Giang',57,1),
	 (N'BX MIỀN TÂY - QUẦY 32-33',N'395 - 397 Kinh Dương Vương, P.An Lạc, Q.Bình Tân, TP.HCM',58,1);
INSERT INTO tblLocations ([LocationName],[Address],[CityID],[Status]) VALUES
	 (N'SUỐI LINH',N'D9 Tổ 2, KP4, XLHN, P.Long Bình, TP. Biên Hòa (ngã 3 Tam Hiệp, Suối Linh)',19,1),
	 (N'BX MIỀN ĐÔNG',N'292 Đinh Bộ Lĩnh, P.26, Q.Bình Thạnh, TP.HCM',58,1),
	 (N'Y DƯỢC',N'15 Lô A Đặng Thái Thân, P.11, Q.5, TP.HCM',58,1),
	 (N'CAO VĂN LẦU',N'94 Cao Văn Lầu, Q.6, TP.HCM',58,1),
	 (N'ĐỀ THÁM',N'272 Đề Thám, P.Pham ngũ Lão, Q.1, TP.HCM',58,1),
	 (N'231 LÊ HỒNG PHONG',N'231 - 233 Lê Hồng Phong, P.4, Q.5, TP.HCM',58,1),
	 (N'HÀNG XANH',N'486H Điện Biên Phủ, P.21, Q.Bình Thạnh, TP.HCM',58,1),
	 (N'XA LỘ HÀ NỘI',N'798 Xa Lộ Hà Nội, P.Hiệp Phú, Q.9, TP.HCM',58,1),
	 (N'TRÀ VINH',N'559 QL54, Khóm 4, P.9, TP.Trà Vinh, Trà Vinh (BX Trà Vinh)',59,1),
	 (N'KINH CÙNG',N'TT.Kinh Cùng, H.Phụng Hiệp, Hậu Giang',28,1);
INSERT INTO tblLocations ([LocationName],[Address],[CityID],[Status]) VALUES
	 (N'VỊ THANH',N'Trần Hưng Đạo (nối dài,1), P.5, TP.Vị Thanh, Hậu Giang',28,1),
	 (N'VĨNH TƯỜNG',N'275 Ấp Bình Tân, X.Long Bình, TX.Long Mỹ, Hậu Giang',28,1),
	 (N'CÁI TẮC',N'Ấp Tân Phú, TT.Cái Tắc, H.Châu Thành A, Hậu Giang',28,1),
	 (N'VĨNH LONG',N'1E Đinh Tiên Hoàng, P.8, TP.Vĩnh Long, Vĩnh Long (BX Vĩnh Long)',61,1),
	 (N'Song Phú',N'Lô A-27 Khu đô thị mới Chợ Song Phú, Ấp Phú Ninh, X.Song Phú, H.Tam Bình,Vĩnh Long',61,1),
	 (N'BÌNH MINH',N'Khóm 2, P.Thành Phước, TX.Bình Minh, Vĩnh Long',61,1),
	 (N'BX VŨNG TÀU',N'192 Nam Kỳ Khởi Nghĩa, P.3, TP.Vũng Tàu',2,1),
	 (N'BÀ RỊA',N'Nguyễn Thanh Đằng, P.Phước Hiệp, TP.Bà Rịa, Bà Rịa - Vũng Tàu (BX Bà Rịa)',2,1),
	 (N'ẸO ÔNG TỪ',N'1632 đường 30/4, P.12, TP.Vũng Tàu',2,1),
	 (N'TÂN THÀNH',N'Thôn Tân Ngọc, TT.Phú Mỹ, H.Tân Thành, Bà Rịa - Vũng Tàu',2,1);
INSERT INTO tblLocations ([LocationName],[Address],[CityID],[Status]) VALUES
	 (N'BẾN XE NINH THUẬN',N'52 Quốc lộ 1A, Đài Sơn, Phan Rang-Tháp Chàm, Ninh Thuận',42,1),
	 (N'BX ĐÀ NẴNG',N'37 Nam Trân, P.Hòa Minh, Q.Liên Chiểu, TP.Đà Nẵng (BX Đà Nẵng)',15,1),
	 (N'NAM PHƯỚC',N'QL1 TT.Nam Phước,  H.Duy Xuyên, Quảng Nam (BX Nam phước)',46,1),
	 (N'MA LÂM',N'462 Đường 8/4 (QL28), Khu phố 1, Thị trấn Ma Lâm, Huyện Hàm Thuận Bắc, Bình thuận',11,1),
	 (N'NGÔ GIA TỰ',N'210  Ngô Gia Tự, Phường Thanh Sơn, TP. Phan Rang',42,1),
	 (N'07 HOÀNG HOA THÁM',N'7 Hoàng Hoa Thám, TP.Nha Trang, Khánh Hòa',31,1),
	 (N'BX PHÍA NAM',N'Đường 23/10, TT.Diên Khánh, H.Diên Khánh, Khánh Hòa',31,1),
	 (N'BX PHÍA BẮC',N'01 Đường 2/4, P.Vĩnh Hòa, TP.Nha Trang, Khánh Hòa',31,1),
	 (N'DIÊN KHÁNH',N'181 Lạc Long Quân, TT.Diên Khánh, H.Diên Khánh, Khánh Hòa',31,1),
	 (N'CAM RANH',N'1 Lê Duẩn, P.Cam Lộc, TP.Cam Ranh, Khánh Hòa',31,1);
INSERT INTO tblLocations ([LocationName],[Address],[CityID],[Status]) VALUES
	 (N'Ninh Hòa',N'QL1A, Thôn Thanh Châu, P.Ninh Giang, TX.Ninh Hòa, Khánh Hòa (BX Ninh Hòa)',31,1),
	 (N'PHAN RÍ',N'Quốc Lộ  1A, Thị trấn Phan Rí Cửa, Huyện Tuy Phong, Tỉnh Bình Thuận',11,1),
	 (N'PHÚ QUÝ',N'144 QL1A Phú Quý, Thị trấn Phước Dân, Huyện Ninh Phước, Ninh Thuận',42,1),
	 (N'QUẢNG NGÃI',N'Bà Triệu, P.Nghĩa Chánh, TP.Quảng Ngãi, Quảng Ngãi',47,1),
	 (N'BÌNH SƠN',N'Tổ 5 Lê Đại Hành, TT.Châu Ổ, Bình Sơn, Quảng Ngãi',47,1),
	 (N'QUY NHƠN',N'187 Tây Sơn, P.Ghềnh Trắng, TP.Quy Nhơn, Bình Định',8,1),
	 (N'PHÚ TÀI',N'Ngã ba Phú Tài, 129 Lạc Long Quân, P.Trần Quang Diệu, TP.Quy Nhơn, Bình Định',8,1),
	 (N'BX GIÁP BÁT',N'Km số 6, đường Giải Phóng, P.Hoàng Liệt, Q.Hoàng Mai, Hà Nội (BX Giáp Bát)',24,1),
	 (N'BX PHÍA NAM',N'97 An Dương Vương, P.An Tây, TP.Huế, Thừa Thiên - Huế',56,1),
	 (N'BX NAM ĐỊNH',N'Km số 2, đường Điện Biên, X.Lộc Hòa, TP.Nam Định, Nam Định (BX Nam Định)',39,1);



INSERT INTO tblVehicleTypes(VehicleTypeName,TotalSeat) VALUES(N'Xe 24 chỗ',24)
INSERT INTO tblVehicleTypes(VehicleTypeName,TotalSeat) VALUES(N'Xe 22 chỗ',22)
INSERT INTO tblVehicleTypes(VehicleTypeName,TotalSeat) VALUES(N'Xe 34 chỗ',34)
INSERT INTO tblVehicleTypes(VehicleTypeName,TotalSeat) VALUES(N'Xe 42 chỗ',42)

INSERT INTO tblVehicles(VehicleID,VehicleName,LicensePlate,VehicleTypeID,[Status])
VAlUES('VE001','Limousin','51H-95044',1,1)
INSERT INTO tblVehicles(VehicleID,VehicleName,LicensePlate,VehicleTypeID,[Status])
VAlUES('VE002','Limousin','51A-85144',1,1)
INSERT INTO tblVehicles(VehicleID,VehicleName,LicensePlate,VehicleTypeID,[Status])
VAlUES('VE003','Limousin','51F-95044',2,1)
INSERT INTO tblVehicles(VehicleID,VehicleName,LicensePlate,VehicleTypeID,[Status])
VAlUES('VE004','Limousin','30A-12893',3,1)
INSERT INTO tblVehicles(VehicleID,VehicleName,LicensePlate,VehicleTypeID,[Status])
VAlUES('VE005','Limousin','51F-03336',1,1)
INSERT INTO tblVehicles(VehicleID,VehicleName,LicensePlate,VehicleTypeID,[Status])
VAlUES('VE006','Limousin','51G-83060',2,1)
INSERT INTO tblVehicles(VehicleID,VehicleName,LicensePlate,VehicleTypeID,[Status])
VAlUES('VE007','Hyundai County','51C-88634',1,1)
INSERT INTO tblVehicles(VehicleID,VehicleName,LicensePlate,VehicleTypeID,[Status])
VAlUES('VE008','Limousin','51T-99999',1,1)
INSERT INTO tblVehicles(VehicleID,VehicleName,LicensePlate,VehicleTypeID,[Status])
VAlUES('VE009','Hyundai Universe','75A-14519',3,1)
INSERT INTO tblVehicles(VehicleID,VehicleName,LicensePlate,VehicleTypeID,[Status])
VAlUES('VE010','Hyundai Aero Hi-class','34A-12913',3,1)
INSERT INTO tblVehicles(VehicleID,VehicleName,LicensePlate,VehicleTypeID,[Status])
VAlUES('VE011','Hyundai Space','51U-13436',4,1)
INSERT INTO tblVehicles(VehicleID,VehicleName,LicensePlate,VehicleTypeID,[Status])
VAlUES('VE012','Huyndai Aero Town','51C-13560',4,1)

INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('030202034704',N'Kiều Minh Hiếu','2002-08-23',1,'','0912345678',1)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('065947369485',N'Nguyễn Hiển Vinh','2002-06-24',1,'','0912345678',1)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('384950384739',N'Lê Tuấn Tài','1993-07-29',1,'','0912345678',1)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('483957209388',N'Trần Nhật Tuân','1995-07-26',1,'','0912345678',2)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('574839205937',N'Nguyễn Vinh Hoa','1992-07-29',1,'','0912345678',0)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('844958937398',N'Đặng Tuấn Tài','1994-07-23',1,'','0912345678',1)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('849504739458',N'Tô Mỹ Lệ','2000-01-27',0,'','0912345678',1)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('889378529034',N'Ngô Ngọc Vân Trang','2002-02-24',0,'','0912345678',2)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('894590459723',N'Đăng Thị Hương','1997-03-12',0,'','0912345678',0)

INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT001',N'Việt Nam','B1','1997-03-12' ,'030202034704')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT002',N'Việt Nam','D','1997-03-12','065947369485')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT003',N'Việt Nam','C','1997-03-12','384950384739')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT004',N'Việt Nam','B2','1997-03-12','483957209388')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT005',N'Việt Nam','C','1997-03-12','574839205937')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT006',N'Việt Nam','D','1997-03-12','844958937398')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT007',N'Việt Nam','B2','1997-03-12','849504739458')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT008',N'Việt Nam','C','1997-03-12','889378529034')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT009',N'Việt Nam','D','1997-03-12','894590459723')

INSERT INTO tblRoutes(RouteName,StartLocation,EndLocation,[Description],[Status])
VALUES(N'Hồ Chí Minh - Đà Lạt', 1,3,'',1)
INSERT INTO tblRoutes(RouteName,StartLocation,EndLocation,[Description],[Status])
VALUES(N'Hồ Chí Minh - Nha Trang', 1,4,'',1)
INSERT INTO tblRoutes(RouteName,StartLocation,EndLocation,[Description],[Status])
VALUES(N'Hồ Chí Minh - Lào Cai', 1,8,'',1)
INSERT INTO tblRoutes(RouteName,StartLocation,EndLocation,[Description],[Status])
VALUES(N'Hồ Chí Minh - Phan Thiết', 1,9,'',1)
INSERT INTO tblRoutes(RouteName,StartLocation,EndLocation,[Description],[Status])
VALUES(N'Nha Trang - Đà Lạt', 4,3,'',1)
INSERT INTO tblRoutes(RouteName,StartLocation,EndLocation,[Description],[Status])
VALUES(N'Hà Nội - SaPa', 2,11,'',1)
INSERT INTO tblRoutes(RouteName,StartLocation,EndLocation,[Description],[Status])
VALUES(N'Hồ Chí Minh - Vũng Tàu', 1,10,'',1)
INSERT INTO tblRoutes(RouteName,StartLocation,EndLocation,[Description],[Status])
VALUES(N'Hồ Chí Minh - Gia Lai', 1,14,'',1)
INSERT INTO tblRoutes(RouteName,StartLocation,EndLocation,[Description],[Status])
VALUES(N'Hồ Chí Minh - Phú Yên', 1,15,'',1)
INSERT INTO tblRoutes(RouteName,StartLocation,EndLocation,[Description],[Status])
VALUES(N'Bình Thuận - Phan Thiết', 12,9,'',1)

INSERT INTO tblCities VALUES
    (N'An Giang'),
    (N'Bà Rịa - Vũng Tàu'),
    (N'Bắc Giang'),
    (N'Bắc Kạn'),
    (N'Bạc Liêu'),
    (N'Bắc Ninh'),
    (N'Bến Tre'),
    (N'Bình Định'),
    (N'Bình Dương'),
    (N'Bình Phước'),
    (N'Bình Thuận'),
    (N'Cà Mau'),
    (N'Cần Thơ'),
    (N'Cao Bằng'),
    (N'Đà Nẵng'),
    (N'Đắk Lắk'),
    (N'Đắk Nông'),
    (N'Điện Biên'),
    (N'Đồng Nai'),
    (N'Đồng Tháp'),
    (N'Gia Lai'),
    (N'Hà Giang'),
    (N'Hà Nam'),
    (N'Hà Nội'),
    (N'Hà Tĩnh'),
    (N'Hải Dương'),
    (N'Hải Phòng'),
    (N'Hậu Giang'),
    (N'Hòa Bình'),
    (N'Hưng Yên'),
    (N'Khánh Hòa'),
    (N'Kiên Giang'),
    (N'Kon Tum'),
    (N'Lai Châu'),
    (N'Lâm Đồng'),
    (N'Lạng Sơn'),
    (N'Lào Cai'),
    (N'Long An'),
    (N'Nam Định'),
    (N'Nghệ An'),
    (N'Ninh Bình'),
    (N'Ninh Thuận'),
    (N'Phú Thọ'),
    (N'Phú Yên'),
    (N'Quảng Bình'),
    (N'Quảng Nam'),
    (N'Quảng Ngãi'),
    (N'Quảng Ninh'),
    (N'Quảng Trị'),
    (N'Sóc Trăng'),
    (N'Sơn La'),
    (N'Tây Ninh'),
    (N'Thái Bình'),
    (N'Thái Nguyên'),
    (N'Thanh Hóa'),
    (N'Thừa Thiên Huế'),
    (N'Tiền Giang'),
    (N'Thành phố Hồ Chí Minh'),
    (N'Trà Vinh'),
    (N'Tuyên Quang'),
    (N'Vĩnh Long'),
    (N'Vĩnh Phúc'),
    (N'Yên Bái');

