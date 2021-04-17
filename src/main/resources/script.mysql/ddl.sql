CREATE database IF NOT EXISTS `sms`;

CREATE TABLE IF NOT EXISTS `TM_USER`{
    `id` int(11) not null AUTO INCREATEMENT,
    `code` varchar(64) not null,
}