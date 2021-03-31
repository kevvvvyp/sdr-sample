create table stub.child_2
(
    id int not null
        constraint child_2_pk
            primary key nonclustered
)
go

INSERT INTO stub.stub.child_2 (id) VALUES (1);