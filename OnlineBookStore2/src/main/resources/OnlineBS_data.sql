INSERT INTO books (id, name, uuid, image_url, author, description, price) VALUES 
(1, 'NightMare on elmStreet', UUID(), 'elmStreet.jfif', 'Stephen King', 'A horror movie about dreams', 20.00);

INSERT INTO books (id, name, uuid, image_url, author, description, price) VALUES 
(2, 'Kung fu panda', UUID(), 'kingfu-Panda.jfif', 'DreamWorks', 'A fighting panda', 15.00);

INSERT INTO books (id, name, uuid, image_url, author, description, price) VALUES 
(3, 'James Bond', UUID(), 'jamesBond.jfif', 'Fighting kittens', 'Old man can fight', 25.00);

INSERT INTO books (id, name, uuid, image_url, author, description, price) VALUES 
(4, 'The Great Gatsby', UUID(), 'theGreatGatsby.jpg', 'F. Scott Fitzgerald', 'A classic novel set in the Jazz Age', 22.00);

INSERT INTO books (id, name, uuid, image_url, author, description, price) VALUES 
(5, 'To Kill a Mockingbird', UUID(), 'toKillAMockingbird.jpg', 'Harper Lee', 'A novel about racial injustice in the Deep South', 29.00);

INSERT INTO books (id, name, uuid, image_url, author, description, price) VALUES 
(6, '1984', UUID(), `'1984.jpg', 'George Orwell', 'A dystopian novel about totalitarianism', 19.00);

INSERT INTO books (id, name, uuid, image_url, author, description, price) VALUES 
(7, 'Pride and Prejudice', UUID(), 'prideAndPrejudice.jpg', 'Jane Austen', '
A romantic novel about manners and marriage', 21.00);

INSERT INTO books (id, name, uuid, image_url, author, description, price) VALUES 
(8, 'War and peace', UUID(), 'warAndPeace.jpg', 'Leo Tolstoy', 'A historical novel set against the backdrop of the Napoleonic Wars', 18.00);

INSERT INTO books (id, name, uuid, image_url, author, description, price) VALUES 
(9, 'Moby Dick', UUID(), 'mobyDick.jpg', 'Hermen Melville', '
A novel about the obsessive quest of Ahab for revenge', 24.00);


INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
  VALUES ('ADMIN',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
  VALUES ('STUDENT',CURDATE(),'DBA');