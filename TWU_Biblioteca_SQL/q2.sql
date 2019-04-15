SELECT COUNT(name)
FROM member
WHERE member.id NOT IN (
 SELECT member.id
 FROM checkout_item, member
 WHERE checkout_item.member_id = member.id
);

