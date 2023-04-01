DELETE FROM sys_user;
DELETE FROM sys_class;

INSERT INTO sys_user (id, name, age, email, class_id)
VALUES (1, 'Jone', 18, 'test1@baomidou.com', 1),
       (2, 'Jack', 20, 'test2@baomidou.com', 1),
       (3, 'Tom', 28, 'test3@baomidou.com', 3),
       (4, 'Sandy', 21, 'test4@baomidou.com', 2),
       (5, 'Billie', 24, 'test5@baomidou.com', 3);

INSERT INTO sys_class(id, name, desc)
VALUES (1, 'class-01', 'experimental class'),
       (2, 'class-02', 'olympic Mathmatics training class'),
       (3, 'class-03', 'junior class');