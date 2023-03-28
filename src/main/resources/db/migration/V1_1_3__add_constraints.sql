alter table post_tag add CONSTRAINT fk_post FOREIGN KEY(post_id) REFERENCES posts(id) on delete cascade;
alter table post_tag add CONSTRAINT fk_tag FOREIGN KEY(tag_id) REFERENCES tags(id) on delete cascade;
