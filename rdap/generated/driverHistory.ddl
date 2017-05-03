DROP TABLE IF EXISTS DRIVER_HISTORY CASCADE;

CREATE TABLE "DRIVER_HISTORY" (
	"ID" INTEGER NOT NULL,
	"T_STAMP" DATE NOT NULL,
	"FIRST_NAME" TEXT NOT NULL,
	"LAST_NAME" TEXT NOT NULL,
	"LICENSE_NUMBER" TEXT NOT NULL,
	"VIN" TEXT NOT NULL,
	"DESCRIPTION" TEXT NOT NULL,
	"SEVERITY" INTEGER NOT NULL,
	PRIMARY KEY ( "ID" )
);


--DRIVER_HISTORY

INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '100', '2015-01-05 13:07:56.209', 'Lisa', 'Simpson', 'L11234456778966', '** unknown **', 'VEHICLE WITHIN 20 FEET OF CROSSWALK', '3' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '101', '2006-02-02 13:46:04.059', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'TAGS ISSUED TO ANOTHER VEHICLE', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '102', '2003-07-12 09:14:18.944', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'FAIL TO YIELD', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '103', '2000-11-21 13:35:29.508', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'OPERATING MOTOR VEHICLE WITH SUSPENDED LICENSE', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '104', '2000-09-15 09:17:48.935', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'PERSON DRIVING MOTOR VEHICLE WHILE LICENSE SUSPENDED', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '105', '2009-11-21 05:56:32.16', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'THROWING/DUMPING/DEPOSIT REFUSE ON HWY', '4' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '106', '2006-11-09 15:52:54.328', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'TAILLIGHT INOPERATIVE', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '107', '2007-12-14 01:39:58.891', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'REFUSING TO SIGN A TRAFFIC CITATION AFTER REQUEST', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '108', '2016-05-12 01:09:52.573', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'BICYCLE OPERATOR FAIL TO RIDE RIGHT SIDE OF ROAD', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '109', '2004-06-06 16:44:33.183', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'PASS REAR BRAKE LIGHT INOPERATIVE', '4' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '110', '2007-08-18 23:51:42.748', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'WINDOW GLAZING IMPROPER', '2' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '111', '2010-09-17 15:09:24.725', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'PERSON DRIVING MOTOR VEHICLE WHILE LICENSE SUSPENDED', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '112', '2010-05-12 23:40:11.091', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 45 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '113', '2005-07-16 10:43:36.555', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'OPERATING MOTOR VEHICLE NOT RESTRAINED BY SEAT BELT', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '114', '2014-08-07 05:21:02.068', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'ENDANGERING HEALTH/SAFETY/WELFARE OF DOG BY LEAVING DOG IN UNATTENDED IN MOTOR VEHICLE', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '115', '2000-10-16 05:17:31.97', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 20 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '116', '2014-03-01 17:12:23.143', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 45 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '117', '2011-07-05 18:34:26.088', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 55 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '118', '2016-09-09 19:54:57.34', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'BROKEN REAR TAG LAMP', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '119', '2005-04-27 04:38:12.342', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 70 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '120', '2000-02-23 17:07:49.398', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVER FAILING TO STOP AT RED SIGNAL BEFORE LEFT TURN', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '121', '2007-10-21 00:34:18.808', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'BICYCLE OPERATOR FAIL TO RIDE RIGHT SIDE OF ROAD', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '122', '2016-06-14 22:51:16.755', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'BROKEN REAR TAG LAMP', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '123', '2011-11-03 03:37:08.075', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'PERSON KNOWINGLY MAKING FALSE VEHICLE THEFT REPORT TO POLICE', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '124', '2011-01-26 00:33:27.945', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'PASS REAR BRAKE LIGHT INOPERATIVE', '4' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '125', '2008-11-19 02:21:53.104', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 15 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '126', '2008-03-19 01:16:02.603', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'VEHICLE WITHIN 15 FEET FIRE HYDRANT', '3' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '127', '2005-12-21 06:05:12.164', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 50 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '128', '2009-07-11 15:59:23.258', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVER FAILURE TO STOP FOR PEDESTRAIN IN CROSSWALK', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '129', '2014-02-25 13:44:43.672', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'PERSON DRIVING MOTOR VEHICLE WHILE LICENSE SUSPENDED', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '130', '2001-06-21 16:07:26.56', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'UNLAWFUL POSSESSION OF MASTER KEY TO OPERATE ANY MOTOR VEHICLE', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '131', '2012-08-31 06:24:27.731', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'BICYCLE OPERATOR FAIL TO RIDE RIGHT SIDE OF ROAD', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '132', '2015-11-29 03:18:49.296', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'THROWING/DUMPING/DEPOSIT REFUSE ON HWY', '4' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '133', '2014-12-27 12:05:02.115', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'TAGS ISSUED TO ANOTHER VEHICLE', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '134', '2001-11-03 21:12:55.859', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'USING PHONE WHILE DRIVING', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '135', '2002-04-14 15:49:25.439', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVING WHILE IMPAIRED BY ALCOHOL', '10' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '136', '2016-01-28 09:45:15.718', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 50 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '137', '2014-08-20 21:12:49.911', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 35 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '138', '2013-07-15 22:06:37.065', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'STOPPING VEHICLE IN INTERSECTION', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '139', '2007-02-07 15:50:03.26', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 10 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '140', '2012-02-07 19:23:46.994', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'WINDOW DAMAGED', '1' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '141', '2011-03-14 11:07:23.795', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'BROKEN REAR TAG LAMP', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '142', '2004-09-25 16:22:14.894', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 30 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '143', '2007-11-15 06:31:36.574', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING SPEED LIMIT IN SCHOOL ZONE', '9' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '144', '2010-07-06 03:55:32.419', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVING AN UNINSURED VEHICLE', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '145', '2015-07-25 17:05:39.776', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVING WITHOUT LICENSE', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '146', '2007-06-09 13:38:52.614', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'FAIL TO YIELD', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '147', '2013-12-16 17:18:37.287', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'VEHICLE WITHIN 15 FEET FIRE HYDRANT', '3' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '148', '2010-03-27 23:31:12.339', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'PERSON DRIVING MOTOR VEHICLE WHILE LICENSE SUSPENDED', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '149', '2017-04-04 08:18:54.931', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVING EXPIRED REGISTRATION PLATES', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '150', '2015-04-15 19:03:42.929', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'PERSON DRIVING MOTOR VEHICLE WHILE LICENSE SUSPENDED', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '151', '2013-10-21 07:30:49.573', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'FAILURE TO RETURN TO AND REMAIN AT SCENE OF ACCIDENT', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '152', '2000-10-07 13:13:00.469', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 70 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '153', '2001-08-19 17:19:28.101', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING SPEED LIMIT IN SCHOOL ZONE', '9' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '154', '2005-11-10 12:32:38.395', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING SPEED LIMIT IN SCHOOL ZONE', '9' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '155', '2006-02-07 01:12:23.062', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'WILLFULLY DISOBEYING LAWFUL ORDER OF A POLICE OFFICER', '9' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '156', '2006-04-21 00:01:15.269', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'BICYCLE OPERATOR FAIL TO RIDE RIGHT SIDE OF ROAD', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '157', '2015-07-19 13:07:04.999', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'BRAKES -20% BRAKE CRITERIA', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '158', '2003-05-07 18:03:51.741', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 25 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '159', '2000-04-18 13:03:56.169', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 5 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '160', '2009-12-27 09:16:49.395', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'STOPPING VEHICLE IN INTERSECTION', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '161', '2004-04-25 22:00:21.656', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'PERSON DRIVING MOTOR VEHICLE WHILE LICENSE SUSPENDED', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '162', '2002-05-03 11:03:54.366', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'RIDING BICYCLE ON ROADWAY WHERE SMOOTH SHOULDER AVAILABLE', '4' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '163', '2016-11-02 06:04:31.544', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 25 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '164', '2015-01-31 07:27:08.275', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'VEHICLE WITHIN 15 FEET FIRE HYDRANT', '3' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '165', '2006-06-29 04:20:31.254', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVING MOTOR VEHICLE WITH OBSTRUCTED VIEW', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '166', '2001-04-28 05:49:37.97', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'UNINSURED MOTOR VEHICLE', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '167', '2006-03-24 13:19:31.147', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'TAILLIGHT INOPERATIVE', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '168', '2006-07-03 14:57:30.726', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVING AN UNINSURED VEHICLE', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '169', '2009-05-02 04:05:49.247', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'STOPPING VEHICLE IN INTERSECTION', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '170', '2012-03-28 14:27:26.875', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVER FAILING TO STOP AT RED SIGNAL BEFORE LEFT TURN', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '171', '2011-08-02 15:23:00.528', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 70 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '172', '2010-11-12 14:38:52.913', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVING MOTOR VEHICLE WITH OBSTRUCTED VIEW', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '173', '2017-02-02 01:59:03.826', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'BRAKES -20% BRAKE CRITERIA', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '174', '2010-06-13 09:35:33.767', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVING MOTOR VEHICLE WITH OBSTRUCTED VIEW', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '175', '2010-04-22 07:04:53.589', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 40 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '176', '2009-12-04 14:32:33.656', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'WINDOW DAMAGED', '1' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '177', '2012-07-05 02:05:13.466', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'THROWING/DUMPING/DEPOSIT REFUSE ON HWY', '4' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '178', '2005-04-02 03:51:06.306', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'STOPPING VEHICLE IN INTERSECTION', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '179', '2011-04-30 01:00:18.091', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 25 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '180', '2006-08-23 18:35:51.385', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'PEDESTRIAN FAIL TO OBEY DONT WALK', '2' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '181', '2011-02-10 19:07:01.291', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 70 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '182', '2014-06-15 03:03:57.904', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVING VEHICLE WHILE IMPAIRED BY DRUGS', '10' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '183', '2000-05-12 18:36:46.271', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVER FAILURE TO USE TURN SIGNAL LAMP BEFORE TURN', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '184', '2004-02-11 07:57:37.644', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'THROWING/DUMPING/DEPOSIT REFUSE ON HWY', '4' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '185', '2006-03-03 16:25:56.502', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 65 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '186', '2001-04-28 12:15:23.19', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVING WHILE IMPAIRED BY ALCOHOL', '10' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '187', '2015-03-21 23:23:13.857', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'FAILURE TO REDUCE SPEED IN DANGEROUS WEATHER', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '188', '2008-07-20 21:30:07.671', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'PARKING VEHICLE ON SIDEWALK', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '189', '2016-01-23 10:09:16.371', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'UNLAWFUL POSSESSION OF MASTER KEY TO OPERATE ANY MOTOR VEHICLE', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '190', '2004-12-30 23:43:54.149', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVER FAILURE TO STOP FOR PEDESTRAIN IN CROSSWALK', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '191', '2000-07-30 22:57:51.698', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', '0PERATING A MOTOR SCOOTER ON HWY W/O REQUIRED LICENSE OR PERMIT', '6' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '192', '2008-11-04 18:20:10.832', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'TURN SIGNAL INOPERATIVE', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '193', '2006-07-24 20:40:55.114', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 15 MPH', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '194', '2003-01-02 22:09:39.827', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVER FAILURE TO STOP FOR PEDESTRAIN IN CROSSWALK', '8' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '195', '2005-06-04 04:29:53.299', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'FAILURE TO RETURN TO AND REMAIN AT SCENE OF ACCIDENT', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '196', '2014-10-21 15:51:42.162', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'PEDESTRIAN FAIL TO OBEY DONT WALK', '2' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '197', '2001-07-07 23:12:44.365', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'TRAILER REVERSE LAMP INOPERABLE', '5' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '198', '2016-01-04 07:23:27.572', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'OPERATING MOTOR VEHICLE NOT RESTRAINED BY SEAT BELT', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '199', '2001-08-16 18:56:32.486', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'DRIVING MOTOR VEHICLE WITH OBSTRUCTED VIEW', '7' );
INSERT INTO "DRIVER_HISTORY" ( "ID", "T_STAMP", "FIRST_NAME", "LAST_NAME", "LICENSE_NUMBER", "VIN", "DESCRIPTION", "SEVERITY" ) VALUES ( '200', '2012-12-08 00:10:34.84', 'Bart', 'Simpson', 'B33216654998766', '** unknown **', 'EXCEEDING THE POSTED SPEED LIMIT OF 10 MPH', '8' );


commit;

