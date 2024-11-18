﻿CREATE DATABASE QUANLYVANCHUYEN

CREATE TABLE KhachHang (
    MaKhachHang INT PRIMARY KEY IDENTITY(1,1),
    TenKhachHang NVARCHAR(100),
    SDT VARCHAR(15),
    DiaChi NVARCHAR(200)
);

ALTER TABLE DonHang
ADD CONSTRAINT FK_DonHang_KhachHang FOREIGN KEY (MaKhachHang)
REFERENCES KhachHang(MaKhachHang)
ON DELETE CASCADE;


CREATE TABLE DonHang (
    MaDonHang INT PRIMARY KEY IDENTITY(1,1),
    MaKhachHang INT FOREIGN KEY REFERENCES KhachHang(MaKhachHang),
    NgayDatHang DATE,
    TrangThai NVARCHAR(50),
    GhiChu NVARCHAR(200)
);
ALTER TABLE DonHang
ADD CONSTRAINT DF_NgayDatHang DEFAULT GETDATE() FOR NgayDatHang;
ALTER TABLE DonHang
ADD CONSTRAINT DF_TrangThai DEFAULT N'Chờ xác nhận' FOR TrangThai;


CREATE TABLE XeVanChuyen (
    MaXe INT PRIMARY KEY IDENTITY(1,1),
    BienSo VARCHAR(20),
    TaiXe NVARCHAR(100),
    LoaiXe NVARCHAR(50)
);
ALTER TABLE XeVanChuyen
ADD CONSTRAINT UQ_BienSo UNIQUE (BienSo);

CREATE TABLE ChiTietVanChuyen (
    MaVanChuyen INT PRIMARY KEY IDENTITY(1,1),
    MaDonHang INT FOREIGN KEY REFERENCES DonHang(MaDonHang),
    MaXe INT FOREIGN KEY REFERENCES XeVanChuyen(MaXe),
    NgayGiaoHang DATE,
    TrangThaiVanChuyen NVARCHAR(50)
);
ALTER TABLE ChiTietVanChuyen
DROP COLUMN NgayGiaoHang;

ALTER TABLE ChiTietVanChuyen
ADD CONSTRAINT FK_ChiTietVanChuyen_DonHang FOREIGN KEY (MaDonHang)
REFERENCES DonHang(MaDonHang)
ON DELETE CASCADE;


ALTER TABLE ChiTietVanChuyen
ADD CONSTRAINT FK_ChiTietVanChuyen_XeVanChuyen FOREIGN KEY (MaXe)
REFERENCES XeVanChuyen(MaXe)
ON DELETE CASCADE;
CREATE TABLE Users(
    UserId INT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(50) NOT NULL UNIQUE,
    Pass NVARCHAR(256) NOT NULL,
    Role NVARCHAR(20) NOT NULL,
);

INSERT INTO KhachHang VALUES
('Le tien hai', '0377586361','Vinh Phuc'),
(N'Lò Văn Anh', '0396158395', 'NSơn La'),
(N'Đinh Hải Dương', '0396158395', 'NThanh Hóa')

INSERT INTO DonHang 
VALUES
(1, '2024-10-28', N'Đang vận chuyển', N'Hàng cồng kềnh'),
(2, '2024-1-10',N'Chờ xác nhận',N'Hàng dễ vỡ xin nhẹ tay'),
(3,'2024-12-12',N'Giao thành công','')

INSERT INTO XeVanChuyen
VALUES
('88C-F1-10235',N'Hoàng Minh Quân', 'Wave Alpha'),
('37C-AB-20596',N'Lê Thiên An', 'SH Model'),
('34C-F1-58234',N'Vũ Kim Quý', 'Wave Alpha')



SELECT COUNT(*) FROM DonHang
SELECT * FROM DonHang WHERE (  NgayDatHang = '2024-01-10' AND TrangThai = 'Chờ xác nhận') OR ( MaDonHang = -1)

SELECT * FROM ChiTietVanChuyen
SELECT * FROM KhachHang
SELECT * FROM XeVanChuyen
 SELECT * FROM DonHang
SELECT * FROM ChiTietVanChuyen WHERE MaDonHang = '8'
DELETE DonHang WHERE MaDonHang = 7
