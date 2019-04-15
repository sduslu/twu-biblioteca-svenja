SELECT name
FROM member, book, checkout_item WHERE
member.id = checkout_item.member_id
AND checkout_item.book_id = book.id
AND book.title = 'The Pragmatic Programmer';
