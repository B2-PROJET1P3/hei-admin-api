create table if not exists "version"
(
    id                 varchar
        constraint version_pk primary key                   default uuid_generate_v4(),
    transcript_id      varchar                     not null
        constraint transcript_id_fk references "transcript" (id),
    ref                serial,
    created_by_user_id varchar                     not null
        constraint user_id_fk references "user" (id),
    creation_datetime  timestamp without time zone not null default now()
);
create index if not exists transcript_id_index on "version" (transcript_id);
create index if not exists user_id_index on "version" (created_by_user_id);