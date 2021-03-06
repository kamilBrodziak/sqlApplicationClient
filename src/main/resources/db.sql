PGDMP     4        
    
         w            db #   10.6 (Ubuntu 10.6-0ubuntu0.18.04.1) #   10.6 (Ubuntu 10.6-0ubuntu0.18.04.1)     o           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            p           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            q           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            r           1262    16386    db    DATABASE     t   CREATE DATABASE db WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
    DROP DATABASE db;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            s           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    13041    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            t           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16413 
   applicants    TABLE       CREATE TABLE public.applicants (
    id integer NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(50) NOT NULL,
    phone_number character varying(30) NOT NULL,
    email character varying(100) NOT NULL,
    application_code integer
);
    DROP TABLE public.applicants;
       public         postgres    false    3            �            1259    16411    applicants_id_seq    SEQUENCE     �   CREATE SEQUENCE public.applicants_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.applicants_id_seq;
       public       postgres    false    3    197            u           0    0    applicants_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.applicants_id_seq OWNED BY public.applicants.id;
            public       postgres    false    196            �            1259    16423    mentors    TABLE     f  CREATE TABLE public.mentors (
    id integer NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(50) NOT NULL,
    nick_name character varying(30) NOT NULL,
    phone_number character varying(25) NOT NULL,
    email character varying(50) NOT NULL,
    city character varying(50) NOT NULL,
    favourite_number integer
);
    DROP TABLE public.mentors;
       public         postgres    false    3            �            1259    16421    mentors_id_seq    SEQUENCE     �   CREATE SEQUENCE public.mentors_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.mentors_id_seq;
       public       postgres    false    199    3            v           0    0    mentors_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.mentors_id_seq OWNED BY public.mentors.id;
            public       postgres    false    198            �
           2604    16416    applicants id    DEFAULT     n   ALTER TABLE ONLY public.applicants ALTER COLUMN id SET DEFAULT nextval('public.applicants_id_seq'::regclass);
 <   ALTER TABLE public.applicants ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    196    197            �
           2604    16426 
   mentors id    DEFAULT     h   ALTER TABLE ONLY public.mentors ALTER COLUMN id SET DEFAULT nextval('public.mentors_id_seq'::regclass);
 9   ALTER TABLE public.mentors ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    199    198    199            j          0    16413 
   applicants 
   TABLE DATA               f   COPY public.applicants (id, first_name, last_name, phone_number, email, application_code) FROM stdin;
    public       postgres    false    197   �       l          0    16423    mentors 
   TABLE DATA               t   COPY public.mentors (id, first_name, last_name, nick_name, phone_number, email, city, favourite_number) FROM stdin;
    public       postgres    false    199   �       w           0    0    applicants_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.applicants_id_seq', 10, true);
            public       postgres    false    196            x           0    0    mentors_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.mentors_id_seq', 22, true);
            public       postgres    false    198            �
           2606    16420 *   applicants applicants_application_code_key 
   CONSTRAINT     q   ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_application_code_key UNIQUE (application_code);
 T   ALTER TABLE ONLY public.applicants DROP CONSTRAINT applicants_application_code_key;
       public         postgres    false    197            �
           2606    16418    applicants applicants_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.applicants DROP CONSTRAINT applicants_pkey;
       public         postgres    false    197            �
           2606    16428    mentors mentors_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.mentors
    ADD CONSTRAINT mentors_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.mentors DROP CONSTRAINT mentors_pkey;
       public         postgres    false    199            j   �  x�U��n�0E���L�%(P]�n��L+�����.��0�s�e���@����6B�AJm�<��oz��q�i�0&�J�Ķ��MJG��#|��}T��ģf�x��]�[I���W`��ꅆ����0g��ߩ:�z� ۳����m5�>��r��0-%Zi�|�XG�V�p��}N�v�i�cGy�J7�.�[��P�1-���)�1�׳��}L�R����V�Ӯ�r�i�i�Ba����+])3��8f0RO)�@�C�����Ï��
��W��kr��g;\��&ʮ�ei���.�C�;��X�2p-<�6^y�;"r���N�Ϧ��N!n�l�h�r��tbB�%U?oTbB���=�(G-��#w+������k�
~c w������Z�V�4)�I��2��ƚf���G��\q��M��f�W+���<      l   5  x�}��n�6��ç�HE}ޚ�n� �6�sZ�e,�B�h��ҭ�=�أ�!@^@�{uh[rX�-R?�=���VÍ�Mї
nQ+���L��&��j�:�f%c�_�
n�-�.��g�b��+���7���a�g1Ͻ��!Xt�o�i��	�HzJjX�F�{���Q-ȼ X�c|�gދ}x\�F�"�r��g���>t�<eƉ�q�AE���RB��B�=V��½�6辏��e�b��o0/�������mq��tvrQF�e^�D^
���|�G߫^5X�'���p^�rx�YwߥU��I������\i����	�s��eE�֏T�W4w�*�C�%��@U:�_;fFN��ɹ�jA]��a��5���q��F����qN-f<��a�v��Q�/��N�n*�K:�E�L�.kb��&ĥ���9|1�%Qׄ�Z����hd�g��ddO��!�҄�J��}+�Ԭ�����ݘzEc�=b�lV���F0.�v���M��&��F"�lwȌ\�x��fخ�~xiz;����8+T J�6\Q�f�9��[	ת�]pYM��u���i����ӫ��L�nx^ʦ�+�@ՠ�ޙ屸Ԃ䛀�8�/�3��x
�M/�ξ��'�M����w��KY�?�(�#��a�O~��(����T⌺�)T���i,m��� ����,�k_�Y��p�o?`Ѿ��Q���݅>�hJ]D����m+	�O�	p��֥�)�+C�_wt�~H��Y��N
�)�6֢�Z}�wl������s�3f4M�m�4N�ἕ5�� 9���v��3��&�A1     