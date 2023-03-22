package com.lambda;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lambda.util.Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.*;

public class MainAWS {

    private AmazonDynamoDB amazonDynamoDB;

    public static void main(String[] args) {

        List<AwsData> lista = new ArrayList<>();
        lista.add(new AwsData(1,"Internet Of Things", "AWS IoT Core", "Connect devices to the cloud"));
        lista.add(new AwsData(2,"Internet Of Things", "AWS IoT FleetWise", "Easily collect, transform, and transfer vehicle data to the cloud in near-real time"));
        lista.add(new AwsData(3,"Internet Of Things", "AWS IoT SiteWise", "IoT data collector and interpreter"));
        lista.add(new AwsData(4,"Internet Of Things", "AWS IoT TwinMaker", "Optimize operations by easily creating digital twins of real-world systems"));
        lista.add(new AwsData(5,"Internet Of Things", "AWS IoT Greengrass", "Local compute, messaging, and sync for devices"));
        lista.add(new AwsData(6,"Business Applications", "Alexa for Business", "Empower your organization with Alexa"));
        lista.add(new AwsData(7,"Front-End Web & Mobile", "Amazon API Gateway", "Build, deploy, and manage APIs"));
        lista.add(new AwsData(8,"Application Integration", "Amazon AppFlow", "No-code integration for SaaS apps & AWS services"));
        lista.add(new AwsData(9,"End User Computing", "Amazon AppStream 2.0", "Stream desktop applications securely to a browser"));
        lista.add(new AwsData(10,"Analytics", "Amazon Athena", "Query data in S3 using SQL"));
        lista.add(new AwsData(11,"Machine Learning", "Amazon Augmented AI", "Easily implement human review of ML predictions"));
        lista.add(new AwsData(12,"Databases", "Amazon Aurora", "High performance managed relational database"));
        lista.add(new AwsData(13,"Quantum Technologies", "Amazon Braket", "Accelerate quantum computing research"));
        lista.add(new AwsData(14,"Business Applications", "Amazon Chime", "Frustration-free meetings, video calls, and chat"));
        lista.add(new AwsData(15,"Business Applications", "Amazon Chime SDK", "Real-time messaging, audio, video, and screen sharing "));
        lista.add(new AwsData(16,"Networking & Content Delivery", "Amazon CloudFront", "Global content delivery network"));
        lista.add(new AwsData(17,"Analytics", "Amazon CloudSearch", "Managed search service"));
        lista.add(new AwsData(18,"Management & Governance", "Amazon CloudWatch", "Monitor resources and applications"));
        lista.add(new AwsData(19,"Developer Tools", "Amazon CodeCatalyst lista.add(new AwsData(Preview)", "Unified software development service for faster development and delivery on AWS"));
        lista.add(new AwsData(20,"Machine Learning", "Amazon CodeGuru", "Find your most expensive lines of code"));
        lista.add(new AwsData(21,"Security, Identity & Compliance", "Amazon Cognito", "Identity management for your apps"));
        lista.add(new AwsData(22,"Machine Learning", "Amazon Comprehend", "Discover insights and relationships in text"));
        lista.add(new AwsData(23,"Business Applications", "Amazon Connect", "Omnichannel cloud contact center"));
        lista.add(new AwsData(24,"Developer Tools", "Amazon Corretto", "Production-ready distribution of OpenJDK"));
        lista.add(new AwsData(25,"Analytics", "Amazon DataZone lista.add(new AwsData(Preview)", "Unlock data across organizational boundaries with built-in governance"));
        lista.add(new AwsData(26,"Security, Identity & Compliance", "Amazon Detective", "Investigate potential security issues"));
        lista.add(new AwsData(27,"Machine Learning", "Amazon DevOps Guru", "ML-powered cloud operations service to improve application availability"));
        lista.add(new AwsData(28,"Databases", "Amazon DocumentDB", "Fully managed document database"));
        lista.add(new AwsData(29,"Databases", "Amazon DynamoDB", "Managed NoSQL database"));
        lista.add(new AwsData(30,"Compute", "Amazon EC2", "Virtual servers in the cloud"));
        lista.add(new AwsData(31,"Compute", "Amazon EC2 Auto Scaling", "Scale compute capacity to meet demand"));
        lista.add(new AwsData(32,"Compute", "Amazon EC2 Spot Instances", "Run workloads for up to 90% off"));
        lista.add(new AwsData(33,"Storage", "Amazon Elastic Block Store lista.add(new AwsData(EBS)", "EC2 block storage volumes"));
        lista.add(new AwsData(34,"Containers", "Amazon Elastic Container Registry lista.add(new AwsData(ECR)", "Easily store, manage, and deploy container images"));
        lista.add(new AwsData(35,"Containers", "Amazon Elastic Container Service lista.add(new AwsData(ECS)", "Highly secure, reliable, and scalable way to run containers"));
        lista.add(new AwsData(36,"Storage", "Amazon Elastic File System lista.add(new AwsData(EFS)", "Fully managed file system for EC2"));
        lista.add(new AwsData(37,"Machine Learning", "Amazon Elastic Inference", "Deep learning inference acceleration"));
        lista.add(new AwsData(38,"Containers", "Amazon Elastic Kubernetes Service lista.add(new AwsData(EKS)", "The most trusted way to run Kubernetes"));
        lista.add(new AwsData(39,"Media Services", "Amazon Elastic Transcoder", "Easy-to-use scalable media transcoding"));
        lista.add(new AwsData(40,"Databases", "Amazon ElastiCache", "In-memory caching service"));
        lista.add(new AwsData(41,"Analytics", "Amazon EMR", "Hosted Hadoop framework"));
        lista.add(new AwsData(42,"Application Integration", "Amazon EventBridge", "Serverless event bus for SaaS apps & AWS services"));
        lista.add(new AwsData(43,"Analytics", "Amazon FinSpace", "Store, catalog, prepare, and analyze financial industry data in minutes"));
        lista.add(new AwsData(44,"Machine Learning", "Amazon Forecast", "Increase forecast accuracy using machine learning"));
        lista.add(new AwsData(45,"Machine Learning", "Amazon Fraud Detector", "Detect more online fraud faster"));
        lista.add(new AwsData(46,"Storage", "Amazon FSx", "Launch, run, and scale feature-rich and highly-performant file systems with just a few clicks"));
        lista.add(new AwsData(47,"Game Tech", "Amazon GameLift", "Simple, fast, cost-effective dedicated game server hosting"));
        lista.add(new AwsData(48,"Security, Identity & Compliance", "Amazon GuardDuty", "Managed threat detection service"));
        lista.add(new AwsData(49,"Machine Learning", "Amazon HealthLake", "Securely store, transform, query, and analyze health data in minutes"));
        lista.add(new AwsData(50,"Business Applications", "Amazon Honeycode", "Build mobile & web apps without programming"));
        lista.add(new AwsData(51,"Security, Identity & Compliance", "Amazon Inspector", "Automated and continual vulnerability management for Amazon EC2 and Amazon ECR"));
        lista.add(new AwsData(52,"Media Services", "Amazon Interactive Video Service", "Build engaging live stream experiences"));
        lista.add(new AwsData(53,"Machine Learning", "Amazon Kendra", "Reinvent enterprise search with ML"));
        lista.add(new AwsData(54,"Databases", "Amazon Keyspaces lista.add(new AwsData(for Apache Cassandra)", "Managed Cassandra-compatible database"));
        lista.add(new AwsData(55,"Analytics", "Amazon Kinesis", "Analyze real-time video and data streams"));
        lista.add(new AwsData(56,"Media Services", "Amazon Kinesis Video Streams", "Process and analyze video streams"));
        lista.add(new AwsData(57,"Machine Learning", "Amazon Lex", "Build voice and text chatbots"));
        lista.add(new AwsData(58,"Compute", "Amazon Lightsail", "Launch and manage virtual private servers"));
        lista.add(new AwsData(59,"Front-End Web & Mobile", "Amazon Location Service", "Securely and easily add location data to applications"));
        lista.add(new AwsData(60,"Machine Learning", "Amazon Lookout for Equipment", "Detect abnormal equipment behavior by analyzing sensor data"));
        lista.add(new AwsData(61,"Amazon Lookout for Metrics", "Automatically detect anomalies in metrics and identify their root cause", ""));
        lista.add(new AwsData(62,"Machine Learning", "Amazon Lookout for Vision", "Spot product defects using computer vision to automate quality inspection"));
        lista.add(new AwsData(63,"Game Tech", "Amazon Lumberyard", "A free cross-platform 3D game engine, with Full Source, integrated with AWS and Twitch"));
        lista.add(new AwsData(64,"Security, Identity & Compliance", "Amazon Macie", "Discover and protect your sensitive data at scale"));
        lista.add(new AwsData(65,"Blockchain", "Amazon Managed Blockchain", "Create and manage scalable blockchain networks"));
        lista.add(new AwsData(66,"Management & Governance", "Amazon Managed Grafana", "Scalable, secure, and highly available data visualization for your operational metrics, logs, and traces"));
        lista.add(new AwsData(67,"Management & Governance", "Amazon Managed Service for Prometheus", "Highly available, secure, and managed monitoring for your containers"));
        lista.add(new AwsData(68,"Analytics", "Amazon Managed Streaming for Apache Kafka lista.add(new AwsData(MSK)", "Fully managed Apache Kafka service"));
        lista.add(new AwsData(69,"Application Integration", "Amazon Managed Workflows for Apache Airflow lista.add(new AwsData(MWAA)", "Highly available, secure, and managed workflow orchestration for Apache Airflow"));
        lista.add(new AwsData(70,"Databases", "Amazon MemoryDB for Redis", "Redis-compatible, durable, in-memory database service for ultra-fast performance"));
        lista.add(new AwsData(71,"Machine Learning", "Amazon Monitron", "Reduce unplanned equipment downtime with predictive maintenance and machine learning"));
        lista.add(new AwsData(72,"Application Integration", "Amazon MQ", "Managed message broker service"));
        lista.add(new AwsData(73,"Databases", "Amazon Neptune", "Fully managed graph database service"));
        lista.add(new AwsData(74,"Media Services", "Amazon Nimble Studio", "Accelerate content creation in the cloud"));
        lista.add(new AwsData(75,"Machine Learning", "Amazon Omics", "Transform omics data into insights"));
        lista.add(new AwsData(76,"Analytics", "Amazon OpenSearch Service", "Search, visualize, and analyze up to petabytes of text and unstructured data"));
        lista.add(new AwsData(77,"Machine Learning", "Amazon Personalize", "Build real-time recommendations into your applications"));
        lista.add(new AwsData(78,"Front-End Web & Mobile", "Amazon Pinpoint", "Multichannel marketing communications"));
        lista.add(new AwsData(79,"Machine Learning", "Amazon Polly", "Turn text into life-like speech"));
        lista.add(new AwsData(80,"Blockchain", "Amazon Quantum Ledger Database lista.add(new AwsData(QLDB)", "Fully managed ledger database"));
        lista.add(new AwsData(81,"Analytics", "Amazon QuickSight", "Fast business analytics service"));
        lista.add(new AwsData(82,"Databases", "Amazon RDS", "Managed relational database service for MySQL, PostgreSQL, Oracle, SQL Server, and MariaDB"));
        lista.add(new AwsData(83,"Databases", "Amazon Redshift", "Fast, simple, cost-effective data warehousing"));
        lista.add(new AwsData(84,"Machine Learning", "Amazon Rekognition", "Analyze image and video"));
        lista.add(new AwsData(85,"Networking & Content Delivery", "Amazon Route 53", "53 Scalable domain name system lista.add(new AwsData(DNS)"));
        lista.add(new AwsData(86,"Storage", "Amazon S3 Glacier", "Low-cost archive storage in the cloud"));
        lista.add(new AwsData(87,"Machine Learning", "Amazon SageMaker", "Build, train, and deploy machine learning models at scale"));
        lista.add(new AwsData(88,"Machine Learning", "Amazon SageMaker Ground Truth", "Build accurate ML training datasets"));
        lista.add(new AwsData(89,"Security, Identity & Compliance", "Amazon Security Lake lista.add(new AwsData(Preview)", "Automatically centralize your security data with a few clicks"));
        lista.add(new AwsData(90,"Front-End Web & Mobile", "Amazon Simple Email Service lista.add(new AwsData(SES)", "High-scale inbound and outbound email"));
        lista.add(new AwsData(91,"Application Integration", "Amazon Simple Notification Service lista.add(new AwsData(SNS)", "Pub/sub, SMS, email, and mobile push notifications"));
        lista.add(new AwsData(92,"Application Integration", "Amazon Simple Queue Service lista.add(new AwsData(SQS)", "Managed message queues"));
        lista.add(new AwsData(93,"Storage", "Amazon Simple Storage Service lista.add(new AwsData(S3)", "Object storage built to retrieve any amount of data from anywhere"));
        lista.add(new AwsData(94,"AR & VR", "Amazon Sumerian", "Build and run AR and VR applications"));
        lista.add(new AwsData(95,"Machine Learning", "Amazon Textract", "Extract text and data from documents"));
        lista.add(new AwsData(96,"Databases", "Amazon Timestream", "Fully managed time series database"));
        lista.add(new AwsData(97,"Machine Learning", "Amazon Transcribe", "Automatic speech recognition"));
        lista.add(new AwsData(98,"Machine Learning", "Amazon Translate", "Natural and fluent language translation"));
        lista.add(new AwsData(99,"Security, Identity & Compliance", "Amazon Verified Permissions lista.add(new AwsData(Preview)", "Fine-grained permissions and authorization for your applications"));
        lista.add(new AwsData(100,"Networking & Content Delivery", "Amazon VPC", "Isolated cloud resources"));
        lista.add(new AwsData(101,"Business Applications", "Amazon WorkDocs", "Secure enterprise document storage and sharing"));
        lista.add(new AwsData(102,"Business Applications", "Amazon WorkMail", "Secure email and calendaring"));
        lista.add(new AwsData(103,"End User Computing", "Amazon WorkSpaces Family", "Virtual desktop services for every use case"));
        lista.add(new AwsData(104,"Machine Learning", "Apache MXNet on AWS", "Scalable, open-source deep learning framework"));
        lista.add(new AwsData(105,"Migration", "AWS Application Migration Service lista.add(new AwsData(MGN)", "Automate application migration and modernization"));
        lista.add(new AwsData(106,"Front-End Web & Mobile", "AWS Amplify", "Build, deploy, host, and manage scalable web and mobile apps"));
        lista.add(new AwsData(107,"Networking & Content Delivery", "AWS App Mesh", "Monitor and control microservices"));
        lista.add(new AwsData(108,"Compute", "AWS App Runner", "Production web applications at scale made easy for developers"));
        lista.add(new AwsData(109,"Containers", "AWS App2Container", "Containerize and migrate existing applications"));
        lista.add(new AwsData(110,"Serverless", "AWS Application Composer lista.add(new AwsData(Preview)", "Visually design and build serverless applications quickly"));
        lista.add(new AwsData(111,"Migration", "AWS Application Discovery Service", "Discover on-premises applications to streamline migration"));
        lista.add(new AwsData(112,"Front-End Web & Mobile", "AWS AppSync", "Accelerate app development with fully-managed, scalable GraphQL APIs"));
        lista.add(new AwsData(113,"Security, Identity & Compliance", "AWS Artifact", "On-demand access to AWS’ compliance reports"));
        lista.add(new AwsData(114,"Security, Identity & Compliance", "AWS Audit Manager", "Continuously audit your AWS usage to simplify how you assess risk and compliance"));
        lista.add(new AwsData(115,"Compute", "AWS Auto Scaling", "Scale multiple resources to meet demand"));
        lista.add(new AwsData(116,"Storage", "AWS Backup", "Centralized backup across AWS services"));
        lista.add(new AwsData(117,"Compute", "AWS Batch", "Run batch jobs at any scale"));
        lista.add(new AwsData(118,"Cloud Financial Management", "AWS Budgets", "Set custom cost and usage budgets"));
        lista.add(new AwsData(119,"Security, Identity & Compliance", "AWS Certificate Manager", "Manager Provision, manage, and deploy SSL/TLS certificates"));
        lista.add(new AwsData(120,"Management & Governance", "AWS Chatbot", "ChatOps for AWS"));
        lista.add(new AwsData(121,"Analytics", "AWS Clean Rooms lista.add(new AwsData(Preview)", "Match, analyze, and collaborate on datasets–without sharing or revealing underlying data"));
        lista.add(new AwsData(122,"Developer Tools", "AWS Cloud Control API", "Manage AWS and third-party cloud infrastructure with consistent APIs"));
        lista.add(new AwsData(123,"Developer Tools", "AWS Cloud Development Kit lista.add(new AwsData(CDK)", "Model cloud infrastructure using code"));
        lista.add(new AwsData(124,"Networking & Content Delivery", "AWS Cloud Map", "Service discovery for cloud resources"));
        lista.add(new AwsData(125,"Developer Tools", "AWS Cloud9", "Write, run, and debug code on a cloud IDE"));
        lista.add(new AwsData(126,"Management & Governance", "AWS CloudFormation", "Create and manage resources with templates"));
        lista.add(new AwsData(127,"Security, Identity & Compliance", "AWS CloudHSM", "Hardware-based key storage for regulatory compliance"));
        lista.add(new AwsData(128,"Developer Tools", "AWS CloudShell", "Command line access to AWS resources and tools directly from a browser"));
        lista.add(new AwsData(129,"Management & Governance", "AWS CloudTrail", "Track user activity and API usage"));
        lista.add(new AwsData(130,"Developer Tools", "AWS CodeArtifact", "Secure, scalable, and cost-effective artifact management for software development"));
        lista.add(new AwsData(131,"Developer Tools", "AWS CodeBuild", "Build and test code"));
        lista.add(new AwsData(132,"Developer Tools", "AWS CodeCommit", "Store code in private Git repositories"));
        lista.add(new AwsData(133,"Developer Tools", "AWS CodeDeploy", "Automate code deployments"));
        lista.add(new AwsData(134,"Developer Tools", "AWS CodePipeline", "Release software using continuous delivery"));
        lista.add(new AwsData(135,"Developer Tools", "AWS CodeStar", "Develop and deploy AWS applications"));
        lista.add(new AwsData(136,"Developer Tools", "AWS Command Line Interface lista.add(new AwsData(CLI)", "Line Interface Unified tool to manage AWS services"));
        lista.add(new AwsData(137,"Compute", "AWS Compute Optimizer", "Identify optimal AWS Compute resources"));
        lista.add(new AwsData(138,"Management & Governance", "AWS Config", "Track resources inventory and changes"));
        lista.add(new AwsData(139,"Management & Governance", "AWS Control Tower", "Set up and govern a secure, compliant multi-account environment"));
        lista.add(new AwsData(140,"Containers", "AWS Copilot", "AWS Copilot is the easiest way to launch and manage your containerized application on AWS"));
        lista.add(new AwsData(141,"Cloud Financial Management", "AWS Cost and Usage Report", "Access comprehensive cost and usage information"));
        lista.add(new AwsData(142,"Cloud Financial Management", "AWS Cost Explorer", "Analyze your AWS cost and usage"));
        lista.add(new AwsData(143,"Analytics", "AWS Data Exchange", "Find, subscribe to, and use third-party data in the cloud"));
        lista.add(new AwsData(144,"Analytics", "AWS Data Pipeline", "Orchestration service for periodic, data-driven workflows"));
        lista.add(new AwsData(145,"Migration", "AWS Database Migration Service lista.add(new AwsData(DMS)", "Migrate databases with minimal downtime"));
        lista.add(new AwsData(146,"Migration", "AWS DataSync", "Simple, fast, online data transfer"));
        lista.add(new AwsData(147,"Machine Learning", "AWS Deep Learning AMIs", "Deep learning on Amazon EC2"));
        lista.add(new AwsData(148,"Machine Learning", "AWS Deep Learning Containers", "Docker images for deep learning"));
        lista.add(new AwsData(149,"Machine Learning", "AWS DeepComposer", "ML enabled musical keyboard"));
        lista.add(new AwsData(150,"Machine Learning", "AWS DeepLens", "Deep learning enabled video camera"));
        lista.add(new AwsData(151,"Machine Learning", "AWS DeepRacer", "Autonomous 1/18th scale race car, driven by ML"));
        lista.add(new AwsData(152,"Front-End Web & Mobile", "AWS Device Farm", "Test Android, iOS, and web apps on real devices in the AWS cloud"));
        lista.add(new AwsData(153,"Networking & Content Delivery", "AWS Direct Connect", "Dedicated network connection to AWS"));
        lista.add(new AwsData(154,"Security, Identity & Compliance", "AWS Directory Service", "Host and manage active directory"));
        lista.add(new AwsData(155,"Management & Governance", "AWS Distro for OpenTelemetry", "Secure, production-ready open source distribution with predictable performance"));
        lista.add(new AwsData(156,"Compute", "AWS Elastic Beanstalk", "Run and manage web apps"));
        lista.add(new AwsData(157,"Media Services", "AWS Elemental Appliances & Software", "On-premises media solutions"));
        lista.add(new AwsData(158,"Media Services", "AWS Elemental MediaConnect", "Reliable and secure live video transport"));
        lista.add(new AwsData(159,"Media Services", "AWS Elemental MediaConvert", "Convert file-based video content"));
        lista.add(new AwsData(160,"Media Services", "AWS Elemental MediaLive", "Convert live video content"));
        lista.add(new AwsData(161,"Media Services", "AWS Elemental MediaPackage", "Video origination and packaging"));
        lista.add(new AwsData(162,"Media Services", "AWS Elemental MediaStore", "Media storage and simple http origin"));
        lista.add(new AwsData(163,"Media Services", "AWS Elemental MediaTailor", "Video personalization and monetization"));
        lista.add(new AwsData(164,"Containers", "AWS Fargate", "Serverless compute for containers"));
        lista.add(new AwsData(165,"Developer Tools", "AWS Fault Injection Simulator", "Improve resiliency and performance with controlled experiments"));
        lista.add(new AwsData(166,"Security, Identity & Compliance", "AWS Firewall Manager", "Central management of firewall rules"));
        lista.add(new AwsData(167,"Networking & Content Delivery", "AWS Global Accelerator", "Improve global application availability and performance"));
        lista.add(new AwsData(168,"Analytics", "AWS Glue", "Simple, scalable, and serverless data integration"));
        lista.add(new AwsData(169,"Satellite", "AWS Ground Station", "Fully managed ground station as a service"));
        lista.add(new AwsData(170,"Security, Identity & Compliance", "AWS IAM Identity Center", "Manage single sign-on access to AWS accounts and apps"));
        lista.add(new AwsData(171,"Security, Identity & Compliance", "AWS Identity and Access Management", "Securely manage access to services and resources"));
        lista.add(new AwsData(172,"Machine Learning", "AWS Inferentia", "Machine learning inference chip"));
        lista.add(new AwsData(173,"Internet Of Things", "AWS IoT 1-Click", "One click creation of an AWS Lambda trigger"));
        lista.add(new AwsData(174,"Internet Of Things", "AWS IoT Analytics", "Analytics for IoT devices"));
        lista.add(new AwsData(175,"Internet Of Things", "AWS IoT Button", "Cloud programmable dash button"));
        lista.add(new AwsData(176,"Internet Of Things", "AWS IoT Device Defender", "Security management for IoT devices"));
        lista.add(new AwsData(177,"Internet Of Things", "AWS IoT Device Management", "Onboard, organize, and remotely manage IoT devices"));
        lista.add(new AwsData(178,"Internet Of Things", "AWS IoT EduKit", "Learn how to build simple IoT applications with reference hardware and step-by-step tutorials"));
        lista.add(new AwsData(179,"Internet Of Things", "AWS IoT Events", "IoT event detection and response"));
        lista.add(new AwsData(180,"Internet Of Things", "AWS IoT RoboRunner", "Build applications that help fleets of robots work together seamlessly"));
        lista.add(new AwsData(181,"Security, Identity & Compliance", "AWS Key Management Service lista.add(new AwsData(KMS)", "Managed creation and control of encryption keys"));
        lista.add(new AwsData(182,"Analytics", "AWS Lake Formation", "Build a secure data lake in days"));
        lista.add(new AwsData(183,"Compute", "AWS Lambda", "Run code without thinking about servers"));
        lista.add(new AwsData(184,"Management & Governance", "AWS Launch Wizard", "Easily size, configure, and deploy third party applications on AWS"));
        lista.add(new AwsData(185,"Management & Governance", "AWS License Manager", "Track, manage, and control licenses"));
        lista.add(new AwsData(186,"Compute", "AWS Local Zones", "Run latency sensitive applications closer to end users"));
        lista.add(new AwsData(187,"Migration", "AWS Mainframe Modernization", "Migrate, modernize, operate, and run mainframe workloads"));
        lista.add(new AwsData(188,"Management & Governance", "AWS Managed Services", "Infrastructure operations management for AWS"));
        lista.add(new AwsData(189,"Management & Governance", "AWS Management Console", "Web-based user interface"));
        lista.add(new AwsData(190,"Management & Governance", "AWS Management Console Mobile Application", "Access resources on the go"));
        lista.add(new AwsData(191,"Migration", "AWS Migration Hub", "Track migrations from a single place"));
        lista.add(new AwsData(192,"Security, Identity & Compliance", "AWS Network Firewall", "Deploy network security across your Amazon VPCs with just a few clicks"));
        lista.add(new AwsData(193,"Management & Governance", "AWS OpsWorks", "Automate operations with Chef and Puppet"));
        lista.add(new AwsData(194,"Management & Governance", "AWS Organizations", "Central governance and management across AWS accounts"));
        lista.add(new AwsData(195,"Compute", "AWS Outposts", "Run AWS infrastructure on-premises"));
        lista.add(new AwsData(196,"Machine Learning", "AWS Panorama", "Improve your operations with computer vision at the edge"));
        lista.add(new AwsData(197,"Internet Of Things", "AWS Partner Device Catalog", "Curated catalog of AWS-compatible IoT hardware"));
        lista.add(new AwsData(198,"Management & Governance", "AWS Personal Health Dashboard", "Personalized view of AWS service health"));
        lista.add(new AwsData(199,"Networking & Content Delivery", "AWS Private 5G", "Easily deploy, manage, and scale a private cellular network"));
        lista.add(new AwsData(200,"Networking & Content Delivery", "AWS PrivateLink", "Securely access services hosted on AWS"));
        lista.add(new AwsData(201,"Management & Governance", "AWS Proton", "Automate management for container and serverless deployments"));
        lista.add(new AwsData(202,"Management & Governance", "AWS Resilience Hub", "Prepare and protect your applications from disruptions"));
        lista.add(new AwsData(203,"Security, Identity & Compliance", "AWS Resource Access Manager", "Simple, secure service to share AWS resources"));
        lista.add(new AwsData(204,"Robotics", "AWS RoboMaker", "Develop, test, and deploy robotics applications"));
        lista.add(new AwsData(205,"Security, Identity & Compliance", "AWS Secrets Manager", "Rotate, manage, and retrieve secrets"));
        lista.add(new AwsData(206,"Security, Identity & Compliance", "AWS Security Hub", "Unified security and compliance center"));
        lista.add(new AwsData(207,"Compute", "AWS Serverless Application Repository", "Discover, deploy, and publish serverless applications"));
        lista.add(new AwsData(208,"Management & Governance", "AWS Service Catalog", "Create and use standardized products"));
        lista.add(new AwsData(209,"Management & Governance", "AWS Service Management Connector", "Provision, manage and operate AWS resources within Service Management Tools"));
        lista.add(new AwsData(210,"Security, Identity & Compliance", "AWS Shield", "DDoS protection"));
        lista.add(new AwsData(211,"Compute", "AWS SimSpace Weaver", "Build dynamic, large-scale spatial simulations on AWS managed infrastructure"));
        lista.add(new AwsData(212,"Storage", "AWS Snow Family", "Physical edge computing and storage devices for rugged or disconnected environments"));
        lista.add(new AwsData(213,"Application Integration", "AWS Step Functions", "Coordination for distributed applications"));
        lista.add(new AwsData(214,"Storage", "AWS Storage Gateway", "Hybrid storage integration"));
        lista.add(new AwsData(215,"Business Applications", "AWS Supply Chain lista.add(new AwsData(Preview)", "Mitigate risks and lower costs with an ML-powered supply chain application"));
        lista.add(new AwsData(216,"Management & Governance", "AWS Systems Manager", "Gain operational insights and take action"));
        lista.add(new AwsData(217,"Developer Tools", "AWS Tools and SDKs", "Tools and SDKs for AWS"));
        lista.add(new AwsData(218,"Migration", "AWS Transfer Family", "Fully managed SFTP, FTPS, and FTP service"));
        lista.add(new AwsData(219,"Networking & Content Delivery", "AWS Transit Gateway", "Easily scale VPC and account connections"));
        lista.add(new AwsData(220,"Management & Governance", "AWS Trusted Advisor", "Optimize performance and security"));
        lista.add(new AwsData(221,"Networking & Content Delivery", "AWS Verified Access lista.add(new AwsData(Preview)", "Provide secure access to corporate applications without a VPN"));
        lista.add(new AwsData(222,"Networking & Content Delivery", "AWS VPN", "Securely access your network resources"));
        lista.add(new AwsData(223,"Security, Identity & Compliance", "AWS WAF", "Filter malicious web traffic"));
        lista.add(new AwsData(224,"Compute", "AWS Wavelength", "Deliver ultra-low latency applications for 5G devices"));
        lista.add(new AwsData(225,"Architecture Strategy", "AWS Well-Architected Tool", "Review and improve your workloads"));
        lista.add(new AwsData(226,"Business Applications", "AWS Wickr", "Protect enterprise communications with end-to-end encryption"));
        lista.add(new AwsData(227,"Developer Tools", "AWS X-Ray", "Analyze and debug your applications"));
        lista.add(new AwsData(228,"Storage", "AWS Elastic Disaster Recovery lista.add(new AwsData(DRS)", "Scalable, cost-effective application recovery to AWS"));
        lista.add(new AwsData(229,"Networking & Content Delivery", "Elastic Load Balancing lista.add(new AwsData(ELB)", "Distribute incoming traffic across multiple targets"));
        lista.add(new AwsData(230,"Internet Of Things", "FreeRTOS", "Real-time operating system for microcontrollers"));
        lista.add(new AwsData(231,"Migration", "Migration Evaluator lista.add(new AwsData(formerly TSO Logic)", "Create a business case for cloud migration"));
        lista.add(new AwsData(232,"Machine Learning", "PyTorch on AWS", "Flexible open-source machine learning framework"));
        lista.add(new AwsData(233,"Containers", "Red Hat OpenShift Service on AWS", "Managed OpenShift in the cloud"));
        lista.add(new AwsData(234,"Cloud Financial Management", "Reserved Instance lista.add(new AwsData(RI) Reporting", "Dive deeper into your reserved instances lista.add(new AwsData(RIs)"));
        lista.add(new AwsData(235,"Cloud Financial Management", "Savings Plans", "Save up to 72% on compute usage with flexible pricing"));
        lista.add(new AwsData(236,"Machine Learning", "TensorFlow on AWS", "Open-source machine intelligence library"));
        lista.add(new AwsData(237,"Compute", "VMware Cloud on AWS", "Build a hybrid cloud without custom hardware"));

        MainAWS m = new MainAWS();
        // DynamoDB Code:
        for (AwsData a: lista) {
            m.initDynamoDbClient();
            System.out.println(m.toStringID(a.getId_product()) + ": " + m.saveData(a));
        }

    }




    private boolean saveData(AwsData request) {
        String DYNAMODB_TABLE_NAME = "aws_cloud_products";
        Map<String, AttributeValue> attributesMap = new HashMap<>();
        attributesMap.put("id_product", new AttributeValue(toStringID(request.getId_product())));
        attributesMap.put("category", new AttributeValue(request.getCategory()));
        attributesMap.put("product_name", new AttributeValue(request.getProduct_name()));
        attributesMap.put("product_description", new AttributeValue(String.valueOf(request.getProduct_description())));
        try {
            amazonDynamoDB.putItem(DYNAMODB_TABLE_NAME, attributesMap);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    private void initDynamoDbClient() {
        this.amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .build();
    }

    private String toStringID(int id){
        if(String.valueOf(id).length()==1)
            return "00" + id;
        if(String.valueOf(id).length()==2)
            return "0" + id;
        return "" + id;
    }
}