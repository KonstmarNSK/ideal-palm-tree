create table tags(
    id int primary key,
    name varchar(40)
);

create table post_tag(
    tag_id int,
    post_id int

--    CONSTRAINT fk_post
--          FOREIGN KEY(post_id)
--    	  REFERENCES posts(id),
--
--    CONSTRAINT fk_tag
--              FOREIGN KEY(tag_id)
--        	  REFERENCES tags(id)
);