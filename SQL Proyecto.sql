create database BDproyecto;
GO
USE BDproyecto;
GO
CREATE TABLE Usuarios(
	id int primary key identity(1,1),
	Nombre varchar(40),
	edad int,
	sexo char(1),
	fechaRegistro date
);

CREATE TABLE Mediciones(
	id int primary key identity(1,1),
	UserID int foreign key references Usuarios(id),
	peso decimal(5,2),
	talla decimal(4,2)
);

CREATE TABLE IMC(
	id int primary key identity(1,1),
	MedicionID int foreign key references Mediciones(id),
	imc decimal(4,2),
	fechaCalculo date
);

CREATE TABLE Historial(
	id int primary key identity(1,1),
	UsuarioID int foreign key references Usuarios(id),
	tipoCalculo varchar(20),
	resultado decimal(4,2),
	fechaCalculo date
	);

CREATE PROCEDURE GestionarUsuario
    @Operacion VARCHAR(20),
    @Id INT = NULL,
    @Nombre VARCHAR(40) = NULL,
    @Edad INT = NULL,
    @Sexo CHAR(1) = NULL,
    @FechaRegistro DATE = NULL
AS
BEGIN
    IF @Operacion = 'Insertar'
    BEGIN
        INSERT INTO Usuarios (Nombre, Edad, Sexo, FechaRegistro)
        VALUES (@Nombre, @Edad, @Sexo, @FechaRegistro);
    END
    ELSE IF @Operacion = 'Actualizar'
    BEGIN
        UPDATE Usuarios
        SET Nombre = @Nombre, Edad = @Edad, Sexo = @Sexo
        WHERE Id = @Id;
    END
    ELSE IF @Operacion = 'Eliminar'
    BEGIN
        DELETE FROM Usuarios
        WHERE Id = @Id;
    END
    ELSE IF @Operacion = 'Obtener'
    BEGIN
        SELECT * FROM Usuarios WHERE Id = @Id;
    END
END;







EXEC GestionarUsuario 
    @Operacion = 'Insertar', 
    @Nombre = 'Juan Pérez', 
    @Edad = 30, 
    @Sexo = 'M', 
    @FechaRegistro = '2024-10-03';

EXEC GestionarUsuario 
    @Operacion = 'Actualizar', 
    @Id = 1, 
    @Nombre = 'Juan Pérez', 
    @Edad = 31, 
    @Sexo = 'M';

EXEC GestionarUsuario 
    @Operacion = 'Eliminar', 
    @Id = 1;

EXEC GestionarUsuario 
    @Operacion = 'Obtener', 
    @Id = 1;


	
	
select*from Usuarios;
delete from Usuarios;
DBCC CHECKIDENT ('Usuarios', RESEED, 0);
