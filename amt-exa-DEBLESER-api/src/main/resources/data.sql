insert into quotes values (1,'Dr. Seuss', 'Don''t cry because it''s over, smile because it happened.');
insert into quotes values (2,'Oscar Wilde', 'Be yourself; everyone else is already taken.');
insert into quotes values (3,'Albert Einstein', 'Two things are infinite: the universe and human stupidity; and I''m not sure about the universe.');

insert into villes(vil_num,nom) values(1,'Yverdon');
insert into villes(vil_num,nom) values(2,'Fribourg');
insert into villes(vil_num,nom) values(3,'Vevey');
insert into villes(vil_num,nom) values(4,'Lausanne');
insert into villes(vil_num,nom) values(5,'Aubonne');
insert into villes(vil_num,nom) values(6,'Biere');

insert into produits(prd_num,description,poids,statut_livraison,vil_num)
values(1,'Dalles 50x50',300,'dispo',6);
insert into produits(prd_num,description,poids,statut_livraison,vil_num)
values(2,'Poele',400,'dispo',1);
insert into produits(prd_num,description,poids,statut_livraison,vil_num)
values(3,'Sacs gravier',200,'dispo',1);
insert into produits(prd_num,description,poids,statut_livraison,vil_num)
values(4,'Parpaings',200,'dispo',4);
insert into produits(prd_num,description,poids,statut_livraison,vil_num)
values(5,'Truc lourd',700,'dispo',2);
insert into produits(prd_num,description,poids,statut_livraison,vil_num)
values(6,'Brouette',20,'livre',1);

insert into itineraires(itn_num,region) values(1,'Est');
insert into itineraires(itn_num,region) values(2,'Ouest');
insert into itineraires(itn_num,region) values(3,'Ouest');

insert into etapes(itn_num,etp_num,vil_num) values(1,1,1);
insert into etapes(itn_num,etp_num,vil_num) values(1,2,2);
insert into etapes(itn_num,etp_num,vil_num) values(1,3,3);
insert into etapes(itn_num,etp_num,vil_num) values(1,4,4);
insert into etapes(itn_num,etp_num,vil_num) values(2,1,4);
insert into etapes(itn_num,etp_num,vil_num) values(2,2,5);
insert into etapes(itn_num,etp_num,vil_num) values(2,3,6);
insert into etapes(itn_num,etp_num,vil_num) values(2,4,1);

insert into tournees(trn_num,charge_max,charge,itn_num,jour) values(1,1000,0,1,2);
insert into tournees(trn_num,charge_max,charge,itn_num,jour) values(2,800,0,2,1);
