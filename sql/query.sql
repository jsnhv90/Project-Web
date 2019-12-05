--query view book info
select title, category, [language], [format], [page], amount, rating,
b.[description] as 'book description', [first name], [last name], birthdate, country,
 a.[description] as 'author description', [publisher name], [address], phone 
 from Book b inner join Author a on b.[author id] = a.[author id]
inner join Publisher p on b.[publisher id] = p.[publisher id] where ISBN = '545010225'

--paging query
SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY isbn asc) as rownum, 
title, [author id], category, rating, [description], amount FROM Book)
 tblBook WHERE rownum BETWEEN 1 AND 3

--paging + multiple search query
SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY title asc) as rownum, ISBN, 
title, b.[author id], category, rating, b.[description], amount FROM Book b 
inner join Author a on b.[author id] = a.[author id]
inner join Publisher p on b.[publisher id] = p.[publisher id]
where 1 = 1 and title like '%Harry%'
) tblBook WHERE rownum BETWEEN 1 AND 3

--query count total filter
SELECT COUNT(*) as total FROM (SELECT ROW_NUMBER() OVER (ORDER BY title asc) as rownum FROM Book b 
inner join Author a on b.[author id] = a.[author id]
inner join Publisher p on b.[publisher id] = p.[publisher id]
where 1 = 1
) tblBook

--borrow book query
update Book set amount = (select amount - 1 from Book where ISBN = '9780747560722')
where ISBN = '9780747560722' and amount > 0

--query check overdue book
select b.ISBN, title, [borrowed date], [return date] from Book b inner join Borrow br on b.ISBN = br.ISBN 
where username = 'namlh' and [return date] < GETDATE()