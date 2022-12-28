ALTER TABLE student
    add constraint check_age check ( age >= 16 );
ALTER TABLE student
    add constraint student_name_unique unique (name);
ALTER TABLE student
    ALTER COLUMN name set NOT NULL;
ALTER TABLE faculty
    add constraint name_color_unique unique ( name ,color);
ALTER TABLE student
alter column age set default 20;