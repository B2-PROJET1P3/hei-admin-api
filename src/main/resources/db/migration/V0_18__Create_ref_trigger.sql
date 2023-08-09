create or replace function increment_ref()
    returns trigger as
$$
begin
    new.ref = old.ref + 1;
    return new;
end;
$$ language 'plpgsql';

create trigger version_update_trigger
    before update
    on
        "version"
    for each row
execute procedure increment_ref();