SELECT count_books, count_movies, name FROM (SELECT COUNT(checkout_item.book_id) AS count_books, COUNT(checkout_item.movie_id) AS count_movies, checkout_item.member_id, member.name FROM checkout_item, member
WHERE member.id = checkout_item.member_id
GROUP BY checkout_item.member_id
) WHERE (count_books > 1 OR count_movies > 1)
OR (count_books = 1 AND count_movies = 1)
;
