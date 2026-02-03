insert into usuarios (id, nombre, email, capital_disponible) values
(uuid_generate_v4(), 'Sebastian Segovia ', 'sasegovia1@espe.edu.ec', 2000.50),
(uuid_generate_v4(), 'Juan Perez', 'jperez@email.com', 1000.40),
(uuid_generate_v4(), 'Lucia Torres', 'luc-torres@email.com', 7000.00),
(uuid_generate_v4(), 'Maria Guerrero', 'marig@espe.edu.ec', 6000.50),
(uuid_generate_v4(), 'Luis Hidalgo', 'marig@espe.edu.ec', 900.50);

insert into producto_financiero (id, nombre, descripcion, costo, porcentaje_retorno, activo)
values 
(uuid_generate_v4(), 'ETF Global', 'ETF no se que', 1500.00, 12.00, true),
(uuid_generate_v4(), 'Fondo Acciones Tech', 'son fondos no se que', 1000.00, 8.50, true),
(uuid_generate_v4(), 'Bonos Corporativos AAA', 'lleve sus bonos', 500.00, 5.25, true),
(uuid_generate_v4(), 'Fondo de Dividendos', 'lleve sus fondos', 800.00, 6.70, true),
(uuid_generate_v4(), 'Fondos Conservadores', 'ETF no se que', 600.00, 12.00, true),
(uuid_generate_v4(), 'bonos del tesoro', 'ETF no se que', 1500.00, 1.00, true),
(uuid_generate_v4(), 'Fondo preMIUM', 'premium', 950.00, 16.00, true),
(uuid_generate_v4(), 'ETF AAAA', 'AAAno se que', 1900.00, 10.00, true),



