INSERT INTO barbershop (description, lat, logo, lon, name)
  SELECT 'Описание', CONCAT(SUBSTRING(b.lat,1, 4), round(rand() * 1000000)), 'logo.jpg', CONCAT(SUBSTRING(b.lon,1, 4), round(rand() * 1000000)), CONCAT('Example ', round(rand() * 1000))
  FROM barbershop b
 WHERE id = 2