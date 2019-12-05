insert into [Language] values ('English')
insert into [Language] values ('Vietnamese')
insert into [Language] values ('Japanese')

insert into [Format] values('paperback')
insert into [Format] values('hardcover')
insert into [Format] values('mass paperback')

insert into Category values('science fiction')
insert into Category values('novel')
insert into Category values('history')
insert into Category values('self help')
insert into Category values('travel')
insert into Category values('math')
insert into Category values('art')
insert into Category values('autobiography')
insert into Category values('fantasy')
insert into Category values('IT')
insert into Category values('language')

insert into Author values(1, 'J. K.', 'Rowling', '1965-07-31', 'British', 
'J. K. Rowling is a British novelist and screenwriter who wrote the Harry Potter fantasy series.','Rowling.png')

insert into Author values(2, 'J. R. R.', 'Tolkien', '1892-01-03', 'British', 
'Tolkien was an English writer, poet, philologist, and professor who is best known as the author of: The Hobbit, The Lord of the Rings,...','')

insert into Author values(3, 'Stephen', 'King', '1947-09-21', 'USA', 
'Stephen King is an American author of horror, supernatural fiction, suspense, science fiction, and fantasy. He has been known as the "King of Horror".','King.png')

insert into Author values(4, 'Dawn', 'Griffiths', '1980-10-09', 'USA', 
'has over 20 years experience working in the IT industry as Senior Solutions Architect. Dawn is the author of many favorite books.','Griffiths.png')

insert into Author values(5, 'FPT', 'University', '2006-09-08', 'Viet Nam', 'this author belongs to FPT university in Viet Name','University.png')

insert into Author values(6, 'Ian', 'Sommerville', '1951-02-23', 'British', 
'He is the author of a popular student textbook on software engineering. He worked as a professor at the University of St Andrews in Scotland.','Sommerville.png')

insert into Author values(7, 'Anh', 'Nguyen Nhat', '1955-05-07', 'Viet Nam', 'Nguyen Nhat Anh la nha van chuyen viet truyen cho tre em va tuoi moi lon','Anh.png')

insert into Publisher values(1, 'Bloomsbury', '50 Bedford Square, London, WC1B 3DP', '+44 (0)20 7631 5600')
insert into Publisher values(2, 'O''Reilly Media', 'Sebastopol, California, USA', '(707) 827 7000')
insert into Publisher values(3, 'Bach Khoa Ha Noi', 'Hai Ba Trung, Ha Noi, Viet Nam', '+84 24 38684569')
insert into Publisher values(4, 'Pearson', 'London, England, UK', '+44 1223 350555')
insert into Publisher values(5, 'Kim Dong', 'Ha Noi, Viet Nam', '024 3 943 44 90')


 insert into [Administrator] values ('tungnv','Manager')
 insert into [User] values('tungnv', '12345', 'Tung', 'Nguyen', 1, 'tungnvhe130123@fpt.edu.vn', '0984516125', '1995-01-01', 'Viet Nam')

insert into [User] values('manhh', '12345', 'Manh', 'Hoang', 1, 'manhhe123123@fpt.edu.vn', '0984516125', '1995-01-01', 'Viet Nam')
insert into Student values('manhh','He13123')

insert into Book values(0545010225, 'Harry Potter and the Deathly Hallows', 1, 1, 'fantasy','English', 'hardcover', 759, 5, 4.2, null,'Harry1.png')

insert into Book values(9788700631625, 'Harry Potter and the Philosopher Stone', 1, 1, 'fantasy','English', 'paperback', 816, 7, null, 
'Harry Potter''s life is miserable. His parents are dead and he stuck with his heartless relatives, who force him to live in a tiny closet under the stairs. But his fortune changes when he receives a letter that tells him the truth about himself: he''s a wizard. A mysterious visitor rescues him from his relatives and takes him to his new home, Hogwarts School of Witchcraft and Wizardry. Full of sympathetic characters, wildly imaginative situations, and countless exciting details, the first installment in the series assembles an unforgettable magical world and sets the stage for many high-stakes adventures to come.','Harry2.png')

insert into Book values(9780747560722, 'Harry Potter And The Chamber Of Secrets', 1, 1, 'fantasy','English', 'paperback', 705, 3, null, 
null,'Harry3.png')
--harry potter book #2 description (add later)
--'The Dursleys were so mean and hideous that summer that all Harry Potter wanted was to get back to the Hogwarts School for Witchcraft and Wizardry. But just as he''s packing his bags, Harry receives a warning from a strange, impish creature named Dobby who says that if Harry Potter returns to Hogwarts, disaster will strike.
--And strike it does. For in Harry''s second year at Hogwarts, fresh torments and horrors arise, including an outrageously stuck-up new professor, Gilderoy Lockhart, a spirit named Moaning Myrtle who haunts the girls'' bathroom, and the unwanted attentions of Ron Weasley''s younger sister, Ginny. But each of these seem minor annoyances when the real trouble begins, and someone, or something, starts turning Hogwarts students to stone. Could it be Draco Malfoy, a more poisonous rival than ever? Could it possibly be Hagrid, whose mysterious past is finally told? Or could it be the one everyone at Hogwarts most suspects: Harry Potter himself?'

insert into Book values(1449399916, 'Head First C', 4, 2, 'IT','English', 'paperback', 632, 30, 4.5, 
'Ever wished you could learn C from a book? Head First C provides a complete learning experience for C and structured imperative programming. With a unique method that goes beyond syntax and how-to manuals, this guide not only teaches you the language, it helps you understand how to be a great programmer. You''ll learn key areas such as language basics, pointers and pointer arithmetic, and dynamic memory management. Advanced topics include multi-threading and network programming—topics typically covered on a college-level course.
This book also features labs: in-depth projects intended to stretch your abilities, test your new skills, and build confidence. Head First C mimics the style of college-level C courses, making it ideal as an accessible textbook for students. We think your time is too valuable to waste struggling with new concepts. Using the latest research in cognitive science and learning theory to craft a multi-sensory learning experience, Head First C uses a visually rich format designed for the way your brain works, not a text-heavy approach that puts you to sleep.','c.png')

insert into Book values(9786049389207, 'Dekiru Nihongo', 5, 3, 'language','Japanese', 'mass paperback', 302, 1000, 4.0, null,'Nhat.png')

insert into Book values(9870137053469, 'Software Engineering', 6, 4, 'IT','English', 'paperback', 773, 500, 4.4, 
'Intended for introductory and advanced courses in software engineering. The ninth edition of Software Engineering presents a broad perspective of software engineering, focusing on the processes and techniques fundamental to the creation of reliable, software systems. Increased coverage of agile methods and software reuse, along with coverage of "traditional" plan-driven software engineering, gives readers the most up-to-date view of the field currently available. Practical case studies, a full set of easy-to-access supplements, and extensive web resources make teaching the course easier than ever.','SW.png')

insert into Book values(12345678910, 'Kinh Van Hoa', 7, 5, 'novel', 'Vietnamese', 'paperback', 832, 10, null, null,'KVH.png')