create table stub.parent
(
    id           int not null
        constraint parent_pk
            primary key nonclustered,
    parent_value varchar(max)
)
go

INSERT INTO stub.stub.parent (id, parent_value) VALUES (1, N'Parent1');