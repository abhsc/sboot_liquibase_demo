--v1.0
INSERT INTO public.user_info(
	user_id, first_name, last_name, primary_email)
	VALUES (nextval('user_id_seq'), 'alan', 'B-H', 'a@bh.com');
-v1.0
    INSERT INTO public.user_info(
	user_id, first_name, last_name,primary_email)
	VALUES (nextval('user_id_seq'), 'pavi', 'Rama', 'pavi@premier.com');
    
    select * from user_info;

--v1.1
    INSERT INTO public.user_info(
	user_id, first_name, last_name, primary_email)
	VALUES (nextval('user_id_seq'), 'travis', 'cherry', 'travis@premierinc.com');
    
    select * from communication_pref;
    
        INSERT INTO public.user_info(
	user_id, first_name, last_name)
	VALUES (nextval('user_id_seq'), 'eddie', 'esco');
	
	   INSERT INTO public.communication_pref(
	user_id, communication_id)
	VALUES ((select user_id from user_info where last_name='esco'), 'esco@premier.com');
--v1.1	
	INSERT INTO public.user_email(
	user_id, email_type, primary_ind, email_address)
	VALUES (nextval('user_id_seq'), 3, 0, 'esco@gmail.com');