# from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer, Image, Table
# from reportlab.lib.styles import getSampleStyleSheet, ParagraphStyle
# from reportlab.lib.pagesizes import A4
# from reportlab.lib import colors
# from reportlab.lib.units import inch
#
# out='/mnt/data/Priyanshu_Das_Final_Resume_Enhanced.pdf'
# doc=SimpleDocTemplate(out,pagesize=A4,leftMargin=28,rightMargin=28,topMargin=22,bottomMargin=22)
# styles=getSampleStyleSheet()
# styles.add(ParagraphStyle(name='Sec',fontSize=12,textColor=colors.HexColor('#1f4e79'),spaceBefore=7,spaceAfter=4))
# styles.add(ParagraphStyle(name='Txt',fontSize=9.3,leading=11))
# story=[]
#
# img=Image('/mnt/data/mypic.jpeg',1.2*inch,1.2*inch)
# hdr=[[Paragraph("<font size=20><b>Priyanshu Das</b></font><br/><font size=10>Lead Software Engineer | Microservices | Java | Angular</font><br/><font size=9>Hyderabad | priyanshu.das@live.com | LinkedIn / GitHub</font>", styles['Normal']),img]]
# story.append(Table(hdr,colWidths=[6.1*inch,1.2*inch]))
#
# story.append(Paragraph("Professional Summary", styles['Sec']))
# story.append(Paragraph("Accomplished software engineer with 9+ years of experience designing and delivering enterprise-grade products across backend systems, cloud-native platforms, and web applications. Deep hands-on expertise in Java, Spring Boot, RESTful microservices, Angular, distributed systems, SQL, and DevOps automation. Known for strong architectural judgement, concise technical communication, quality-first engineering practices, and leading teams through complete product lifecycles.", styles['Txt']))
#
# story.append(Paragraph("Core Competencies", styles['Sec']))
# story.append(Paragraph("• Java 21, Spring Boot, REST APIs, Microservices, Swagger/OpenAPI, Log4j, Sleuth<br/>• Kafka, Redis, Debezium, asynchronous messaging, resilient system design<br/>• Angular, TypeScript, JavaScript, HTML5, CSS3, jQuery, Node.js, NPM<br/>• MySQL, Oracle, MongoDB, SQL optimization, schema design<br/>• Jenkins, Git, Bitbucket, Maven, Gradle, Docker, Kubernetes, ELK, Splunk, SonarQube<br/>• JUnit, Mockito, Selenium, Cucumber, Gherkin, TDD, Agile / Scrum", styles['Txt']))
#
# story.append(Paragraph("Professional Experience", styles['Sec']))
# story.append(Paragraph("""
# <b>TECHMOJO SOLUTIONS</b> | Member of Technical Staff | 2024–2025<br/>
# • Architected and delivered mission-critical Player Account Management and compliance services with 99.99% uptime.<br/>
# • Designed self-contained microservices using Outbox and CDC patterns for reliable data consistency across systems.<br/>
# • Implemented advanced Redis caching strategies reducing database load by 45% while maintaining low-latency performance.<br/>
# • Drove engineering execution across developers and QA teams in a fast-paced delivery environment.<br/><br/>
#
# <b>REPUTATION.COM</b> | Lead Engineer | 2022–2024<br/>
# • Built scalable Java/Spring Boot services and Angular user interfaces serving high-volume business workflows.<br/>
# • Integrated Kafka-based asynchronous processing to improve responsiveness and scalability.<br/>
# • Established CI/CD pipelines with Jenkins and automated quality gates to accelerate releases.<br/>
# • Produced clear design artefacts and mentored engineers on best practices and architecture.<br/><br/>
#
# <b>EZE SOFTWARE</b> | Senior Software Engineer | 2017–2021<br/>
# • Developed Node.js services for large-scale ingestion and transformation workflows.<br/>
# • Created automation and reporting solutions using Python and MongoDB.<br/><br/>
#
# <b>COGNIZANT</b> | Associate Projects | 2011–2017<br/>
# • Delivered enterprise software using Agile methods with focus on quality and continuous improvement.<br/>
# • Improved API and database performance through monitoring, indexing, and caching.
# """, styles['Txt']))
#
# story.append(Paragraph("Selected Projects", styles['Sec']))
# story.append(Paragraph("""
# <b>E-Commerce Microservices Platform</b><br/>
# • Designed and implemented a modern e-commerce platform using Java 21, Spring Boot, Kafka, Redis, MySQL, and MongoDB.<br/>
# • Built independently deployable services for orders, payments, inventory, and notifications using event-driven communication.<br/>
# • Applied resiliency patterns such as retry, circuit breaker, and asynchronous recovery flows to ensure high availability.<br/>
# • Optimized performance to sustain high transaction throughput with consistently low response times.<br/>
# """, styles['Txt']))
#
# story.append(Paragraph("Education", styles['Sec']))
# story.append(Paragraph("M.Tech, Applied Software Engineering / Computer Science – Scaler Neoversity (2026)<br/>B.Tech, Electronics & Communication Engineering (2010)", styles['Txt']))
#
# story.append(Paragraph("Leadership & Work Style", styles['Sec']))
# story.append(Paragraph("• Passionate about architecture, design excellence, and hands-on engineering.<br/>• Communicates complex ideas clearly through concise technical documentation.<br/>• Drives teams toward end-to-end product development and successful delivery.<br/>• Promotes collaboration, continuous learning, and a positive engineering culture.", styles['Txt']))
#
# doc.build(story)
# print(f"Saved {out}")