-- https://www.mockaroo.com/
insert into clients (id, nom, email, date_naissance, titre) values (next value for seq, 'Wanda Gray', 'wgray0@ebay.co.uk', date '1988-07-26', 2);
insert into clients (id, nom, email, date_naissance, titre) values (next value for seq, 'Lisa Mcdonald', 'lmcdonald1@de.vu', date '1952-06-04', 2);
insert into clients (id, nom, email, date_naissance, titre) values (next value for seq, 'Barbara Kim', 'bkim2@deviantart.com', date '1958-07-31', 2);
insert into clients (id, nom, email, date_naissance, titre) values (next value for seq, 'Kevin Sims', 'ksims3@usatoday.com', date '1986-06-03', 1);
insert into clients (id, nom, email, date_naissance, titre) values (next value for seq, 'Phyllis Johnson', 'pjohnson4@ovh.net', date '1980-10-07', 2);
insert into clients (id, nom, email, date_naissance, titre) values (next value for seq, 'Annie Gutierrez', 'agutierrez5@msu.edu', date '1954-02-02', 2);
insert into clients (id, nom, email, date_naissance, titre) values (next value for seq, 'William Day', 'wday6@squarespace.com', date '1960-05-15', 1);
insert into clients (id, nom, email, date_naissance, titre) values (next value for seq, 'Cheryl Woods', 'cwoods7@storify.com', date '1981-04-08', 2);
insert into clients (id, nom, email, date_naissance, titre) values (next value for seq, 'Richard Cox', 'rcox8@dailymotion.com', date '1996-04-25', 1);
insert into clients (id, nom, email, date_naissance, titre) values (next value for seq, 'Bobby Morris', 'bmorris9@intel.com', date '1990-03-30', 1);

insert into roles (id, libelle) values (1, 'Serveurs');
insert into roles (id, libelle) values (2, 'Responsables');

insert into employes (id, nom, idrole) values (1, 'Katherine Peters', 1);
insert into employes (id, nom, idrole) values (2, 'Jimmy Simmons', 1);
insert into employes (id, nom, idrole) values (3, 'Annie Diaz', 2);
