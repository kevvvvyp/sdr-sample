create table stub.child_1
(
    id            int not null
        constraint child_1_pk
            primary key nonclustered,
    child_1_value varchar(max)
)
go

INSERT INTO stub.stub.child_1 (id, child_1_value) VALUES (1, N'Child1');