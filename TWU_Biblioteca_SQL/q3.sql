SELECT book.title FROM book
WHERE book.title NOT IN (
SELECT title FROM book, checkout_item
WHERE book.id = checkout_item.book_id
);
SELECT movie.title FROM movie
WHERE movie.title NOT IN (
SELECT title FROM movie, checkout_item
WHERE movie.id = checkout_item.movie_id
);

