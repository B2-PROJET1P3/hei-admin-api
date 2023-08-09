insert into "transcript" (id, academic_year, creation_datetime, student, semester, is_definitive)
values ('transcript1_id', 2023, '2023-02-08T08:30:24Z', 'student1_id', 'S1', true),
       ('transcript2_id', 2024, '2023-02-08T08:30:24Z', 'student2_id', 'S2', true);

insert into "transcript"
(id, student_id, semester, academic_year, is_definitive, creation_datetime)
values
    ('transcript3_id','student2_id', 'S6', 2023, true, '2023-11-11T08:25:26.00Z'),
    ('transcript4_id','student2_id', 'S5', 2024, true, '2024-11-12T08:25:26.00Z');