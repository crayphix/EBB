//SQL script for create EBB tables. Some adjustments required depending on db name

create table disbursement
(
  id                  int(25) auto_increment,
  disbursement_amount decimal(15, 2) null,
  funder_id           int(25)        not null,
  disbursement_date   date           null,
  constraint disbursement_id_uindex
    unique (id),
  constraint disbursement_funder_id_fk
    foreign key (funder_id) references ebb.funder (id)
);

alter table disbursement
  add primary key (id);

create table expense
(
  id             int(25) auto_increment
    primary key,
  name           varchar(120)   not null,
  expense_amount decimal(15, 2) null,
  expense_date   date           null,
  funder_id      int(25)        null,
  category       varchar(255)   null,
  constraint expense_funder_id_fk
    foreign key (funder_id) references ebb.funder (id)
);

create table funder
(
  id                    int(25) auto_increment,
  name                  varchar(120) not null,
  category_restrictions varchar(255) null,
  last_state            date         null,
  constraint funder_id_uindex
    unique (id)
);

alter table funder
  add primary key (id);
