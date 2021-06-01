INSERT IGNORE INTO `spring`.`user` (`id`, `username`, `password`,
`algorithm`) VALUES ('1', 'john', '$2a$10$ew8YTnuFj/z8R3aZwA8W6OIORsSguuyraAQ8FhUAMklnGjGft1rVe', 'BCRYPT');
INSERT IGNORE INTO `spring`.`authority` (`id`, `name`, `user_id`) VALUES ('1',
'READ', '1');
INSERT IGNORE INTO `spring`.`authority` (`id`, `name`, `user_id`) VALUES ('2',
'WRITE', '1');
INSERT IGNORE INTO `spring`.`product` (`id`, `name`, `price`, `currency`)
VALUES ('1', 'Chocolate', '10', 'USD');