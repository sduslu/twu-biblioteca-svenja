SELECT COUNT(checkout_item.book_id), COUNT(checkout_item.movie_id), checkout_item.member_id, member.name FROM checkout_item, member
WHERE member.id = checkout_item.member_id
GROUP BY checkout_item.member_id
;
