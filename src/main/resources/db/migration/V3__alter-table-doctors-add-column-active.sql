alter table doctors add active tinyint;
# noinspection SqlWithoutWhere
update doctors set active = 1;