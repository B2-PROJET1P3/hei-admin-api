alter table transcript
    alter column semester drop not null;
alter table transcript
    alter column academic_year drop not null;
alter table transcript
    alter column is_definitive drop not null;
alter table transcript
    alter column creation_datetime drop not null;
alter table transcript
    alter column student drop not null;