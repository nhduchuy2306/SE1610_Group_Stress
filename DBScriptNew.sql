
CREATE DATABASE ETransportationManagement
use ETransportationManagement

---x---
CREATE TABLE tblRoles(
    RoleID char(5) PRIMARY KEY,
    RoleName nvarchar(100)
)
---x---
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
---x---
CREATE TABLE tblLocations(
    LocationID INT IDENTITY PRIMARY KEY,
    LocationName nvarchar(100)
)
---x---
CREATE TABLE tblRoutes(
    RouteID INT IDENTITY PRIMARY KEY,
    RouteName nvarchar(100),
    StartLocation INT FOREIGN KEY REFERENCES tblLocations(LocationID),
    EndLocation INT FOREIGN KEY REFERENCES tblLocations(LocationID),
    [Description] nvarchar(1000),
    [Status] BIT DEFAULT 1
)
---x---
CREATE TABLE tblVehicleTypes(
    VehicleTypeID INT IDENTITY PRIMARY KEY,
    VehicleTypeName nvarchar(100),
    TotalSeat INT NOT NULL
)
---x---
CREATE TABLE tblVehicles(
    VehicleID char(5) PRIMARY KEY,
    VehicleName nvarchar(100),
    LicensePlate nvarchar(20),
    VehicleTypeID INT FOREIGN KEY REFERENCES tblVehicleTypes(VehicleTypeID) ON UPDATE CASCADE ON DELETE SET NULL,
    [Status] INT DEFAULT 1,
)
---x---
CREATE TABLE tblDriverLicenses(
    DriverLicenseID char(12) PRIMARY KEY,
    Nationality nvarchar(100),
    Class char(2) NOT NULL,
    DateExpired DATE,
    DriverID char(5) FOREIGN KEY REFERENCES tblDrivers(DriverID) ON UPDATE CASCADE ON DELETE SET NULL
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

CREATE TABLE tblTrips(
    TripID char(5) NOT NULL PRIMARY KEY,
    TripName nvarchar(100),
    StartDateTime DATETIME NOT NULL,
    [Policy] nvarchar(2000),
    RouteID INT FOREIGN KEY REFERENCES tblRoutes(RouteID) ON UPDATE CASCADE ON DELETE SET NULL,
    VehicleID char(5) FOREIGN KEY REFERENCES tblVehicles(VehicleID) ON UPDATE CASCADE ON DELETE SET NULL,
    DriverID char(5) FOREIGN KEY REFERENCES tblDrivers(DriverID) ON UPDATE CASCADE ON DELETE SET NULL,
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

INSERT INTO tblLocations(LocationName) VALUES(N'Hồ Chí Minh')
INSERT INTO tblLocations(LocationName) VALUES(N'Hà Nội')
INSERT INTO tblLocations(LocationName) VALUES(N'Đà Lạt')
INSERT INTO tblLocations(LocationName) VALUES(N'Nha Trang')
INSERT INTO tblLocations(LocationName) VALUES(N'Đà Nẵng')
INSERT INTO tblLocations(LocationName) VALUES(N'Quảng Bình')
INSERT INTO tblLocations(LocationName) VALUES(N'Ninh Bình')
INSERT INTO tblLocations(LocationName) VALUES(N'Lào Cai')
INSERT INTO tblLocations(LocationName) VALUES(N'Phan Thiết')
INSERT INTO tblLocations(LocationName) VALUES(N'Vũng Tàu')
INSERT INTO tblLocations(LocationName) VALUES(N'SaPa')
INSERT INTO tblLocations(LocationName) VALUES(N'Bình Thuận')
INSERT INTO tblLocations(LocationName) VALUES(N'Đăk Lăk')
INSERT INTO tblLocations(LocationName) VALUES(N'Gia Lai')
INSERT INTO tblLocations(LocationName) VALUES(N'Phú Yên')

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
VALUES('D001',N'Kiều Minh Hiếu','2002-08-23',1,'','0912345678',1)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('D002',N'Nguyễn Hiển Vinh','2002-06-24',1,'','0912345678',1)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('D003',N'Lê Tuấn Tài','1993-07-29',1,'','0912345678',1)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('D004',N'Trần Nhật Tuân','1995-07-26',1,'','0912345678',2)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('D005',N'Nguyễn Vinh Hoa','1992-07-29',1,'','0912345678',0)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('D006',N'Đặng Tuấn Tài','1994-07-23',1,'','0912345678',1)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('D007',N'Tô Mỹ Lệ','2000-01-27',0,'','0912345678',1)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('D008',N'Ngô Ngọc Vân Trang','2002-02-24',0,'','0912345678',2)
INSERT INTO tblDrivers(DriverID,DriverName,DOB,Sex,DriverPic,PhoneNumber,[Status])
VALUES('D009',N'Đăng Thị Hương','1997-03-12',0,'','0912345678',0)

INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT001',N'Việt Nam','B1','1997-03-12' ,'D001')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT002',N'Việt Nam','D','1997-03-12','D002')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT003',N'Việt Nam','C','1997-03-12','D009')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT004',N'Việt Nam','B2','1997-03-12','D003')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT005',N'Việt Nam','C','1997-03-12','D005')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT006',N'Việt Nam','D','1997-03-12','D004')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT007',N'Việt Nam','B2','1997-03-12','D006')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT008',N'Việt Nam','C','1997-03-12','D007')
INSERT INTO tblDriverLicenses(DriverLicenseID,Nationality,Class,DateExpired,DriverID) 
VALUES('VT009',N'Việt Nam','D','1997-03-12','D008')

INSERT INTO tblLocations(LocationName) VALUES(N'Hồ Chí Minh')
INSERT INTO tblLocations(LocationName) VALUES(N'Hà Nội')
INSERT INTO tblLocations(LocationName) VALUES(N'Đà Lạt')
INSERT INTO tblLocations(LocationName) VALUES(N'Nha Trang')
INSERT INTO tblLocations(LocationName) VALUES(N'Đà Nẵng')
INSERT INTO tblLocations(LocationName) VALUES(N'Quảng Bình')
INSERT INTO tblLocations(LocationName) VALUES(N'Ninh Bình')
INSERT INTO tblLocations(LocationName) VALUES(N'Lào Cai')
INSERT INTO tblLocations(LocationName) VALUES(N'Phan Thiết')
INSERT INTO tblLocations(LocationName) VALUES(N'Vũng Tàu')
INSERT INTO tblLocations(LocationName) VALUES(N'SaPa')
INSERT INTO tblLocations(LocationName) VALUES(N'Bình Thuận')
INSERT INTO tblLocations(LocationName) VALUES(N'Đăk Lăk')
INSERT INTO tblLocations(LocationName) VALUES(N'Gia Lai')
INSERT INTO tblLocations(LocationName) VALUES(N'Phú Yên')

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





