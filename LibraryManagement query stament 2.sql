SELECT fullName, roleID
FROM [User]
WHERE id = 'admin'
  AND password = '1'

SELECT id, password, fullName, gender, phone, address, roleID
FROM [User]
Where roleID = 'AD'

UPDATE [User]
SET password='1',
    fullName='',
    gender  = '',
    phone   = '',
    address = ''
WHERE id = 'admin'

SELECT ''
FROM [Book]
WHERE id = 2
  AND available > 0

SELECT id, name, author, publisher, total, available, publishYear
FROM [Book]
Where available > 10

ALTER TABLE [User]
    ADD DEFAULT 1 FOR [status]

ALTER TABLE [Book]
    ADD DEFAULT 1 FOR [status]

ALTER TABLE [Order]
    ADD DEFAULT 0 FOR [returned]

UPDATE Book
SET available = available + 10
WHERE id = 1

SELECT *
FROM Book

SELECT *
FROM [User]

SELECT id, borrowDate, returnDate
FROM [Order]
Where userID = 'user'
  AND returned = 0

UPDATE [Order]
SET returned=1
WHERE id = 8

SELECT *
FROM [Order]


SELECT id, password
FROM [User]
WHERE id = 'admin'

UPDATE [User]
SET password = '2'
WHERE id = 'admin13'

SELECT *
FROM [Order]


SELECT *
FROM [Order]
WHERE returnDate > '2020-7-11'


ALTER TABLE [Book]
    ADD DEFAULT 1 FOR [status]