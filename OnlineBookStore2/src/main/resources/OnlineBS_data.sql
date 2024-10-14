INSERT INTO books (id, name, uuid, image_url, author, description, price) VALUES 
(1, 'NightMare on elmStreet', UUID(), 'C:/Users/kings/Documents/workspace-spring-tool-suite-4-4.22.0.RELEASE/New folder/OnlineBookStore2/src/main/resources/static/assets/image/elmStreet.jfif', 'Stephen King', 'A horror movie about dreams', 20.00);

INSERT INTO books (id, name, uuid, image_url, author, description, price) VALUES 
(2, 'Kung fu panda', UUID(), 'C:/Users/kings/Documents/workspace-spring-tool-suite-4-4.22.0.RELEASE/New folder/OnlineBookStore2/src/main/resources/static/assets/image/kingfu-Panda.jfif', 'DreamWorks', 'A fighting panda', 15.00);

INSERT INTO books (id, name, uuid, image_url, author, description, price) VALUES 
(3, 'James Bond', UUID(), 'C:/Users/kings/Documents/workspace-spring-tool-suite-4-4.22.0.RELEASE/New folder/OnlineBookStore2/src/main/resources/static/assets/image/jamesBond.jfif', 'Fighting kittens', 'Old man can fight', 25.00);

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
  VALUES ('ADMIN',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
  VALUES ('STUDENT',CURDATE(),'DBA');