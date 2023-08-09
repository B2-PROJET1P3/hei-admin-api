do
$$
    begin
        if not exists(select from pg_type where typname = 'claim_status') then
            create type "claim_status" as enum ('OPEN', 'CLOSE');
        end if;
    end
$$;

create table if not exists "claim"
(
    id                varchar
        constraint claim_pk primary key default uuid_generate_v4(),
    version_id        varchar      not null
        constraint version_fk references "version" (id),
    transcript_id     varchar      not null
        constraint transcript_fk references "transcript" (id),
    reason            varchar,
    status            claim_status not null,
    closed_datetime   timestamp with time zone,
    creation_datetime timestamp with time zone
);

create index if not exists claim_status_index on "claim" (status);
