drop table study_set_card;
drop table study_set;
drop table flashcard;
drop table category;
drop table app_user;
drop table user_role;


CREATE TABLE user_roles (
    role_id		SERIAL,
    name	VARCHAR(25) UNIQUE NOT NULL,

    CONSTRAINT pk_user_roles
    PRIMARY KEY (role_id)
);

CREATE TABLE app_users (
    user_id		SERIAL,
    username	VARCHAR(25) UNIQUE NOT NULL,
    password	VARCHAR(256) NOT NULL,
    first_name	VARCHAR(25) NOT NULL,
    last_name	VARCHAR(25) NOT NULL,
    role_id		INT NOT NULL,
    email       VARCHAR(255) NOT NULL UNIQUE,
    confirmed   INT DEFAULT 0,

    CONSTRAINT pk_app_user
    PRIMARY KEY (user_id),

    CONSTRAINT fk_user_role
    FOREIGN KEY (role_id)
    REFERENCES user_roles (role_id)
);

CREATE TABLE categories (
    category_id		SERIAL,
    name			VARCHAR(50) UNIQUE NOT NULL,

    CONSTRAINT pk_categories
    PRIMARY KEY (category_id)
);

CREATE TABLE flashcards (
    flashcard_id	SERIAL,
    question		VARCHAR(1000) UNIQUE NOT NULL,
    answer			VARCHAR(1000) NOT NULL,
    category_id		INT NOT NULL,

    CONSTRAINT pk_flashcards
    PRIMARY KEY (flashcard_id),

    CONSTRAINT fk_flashcard_category
    FOREIGN KEY (category_id)
    REFERENCES categories (category_id)
);

CREATE TABLE study_sets (
    study_set_id	SERIAL,
    name			VARCHAR(100) NOT NULL,
    owner_id		INT NOT NULL,

    CONSTRAINT pk_study_set
    PRIMARY KEY (study_set_id),

    CONSTRAINT fk_study_set_owner
    FOREIGN KEY (owner_id)
    REFERENCES app_users (user_id)
);

CREATE TABLE study_set_cards (
    study_set_id	INT,
    flashcard_id	INT,

    CONSTRAINT pk_ck_study_set_cards
    PRIMARY KEY (study_set_id, flashcard_id),

    CONSTRAINT fk_study_set
    FOREIGN KEY (study_set_id)
    REFERENCES study_sets (study_set_id),

    CONSTRAINT fk_flashcard
    FOREIGN KEY (flashcard_id)
    REFERENCES flashcards (flashcard_id)

);
