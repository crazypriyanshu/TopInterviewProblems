from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer, Table, TableStyle, HRFlowable
from reportlab.lib.styles import getSampleStyleSheet, ParagraphStyle
from reportlab.lib.pagesizes import A4
from reportlab.lib import colors
from reportlab.lib.units import inch

# Path configuration
out = 'C:/Users/Administrator/Documents/sample resumes/Priyanshu_Das_Staff_Architect_Final.pdf'

# Document Setup
doc = SimpleDocTemplate(
    out,
    pagesize=A4,
    leftMargin=35,
    rightMargin=35,
    topMargin=30,
    bottomMargin=30
)

styles = getSampleStyleSheet()

# --- Custom Styles ---
styles.add(ParagraphStyle(
    name='NameTitle',
    fontSize=20,
    leading=24,
    textColor=colors.HexColor('#1f4e79'),
    fontName='Helvetica-Bold',
    alignment=1
))

styles.add(ParagraphStyle(
    name='SecHeader',
    fontSize=11,
    fontName='Helvetica-Bold',
    textColor=colors.HexColor('#1f4e79'),
    spaceBefore=12,
    spaceAfter=6,
    textTransform='uppercase'
))

styles.add(ParagraphStyle(
    name='Txt',
    fontSize=9,
    leading=11,
    fontName='Helvetica',
    alignment=0
))

styles.add(ParagraphStyle(
    name='SubHeader',
    fontSize=9.5,
    leading=12,
    fontName='Helvetica-Bold',
    spaceBefore=4
))

story = []

# --- Header Section ---
story.append(Paragraph("Priyanshu Das", styles['NameTitle']))
header_sub = """
<para align="center">
    <font size=11 color="#444444">Software Architect | Lead Software Engineer | 14+ Years Experience</font><br/>
    <font size=9>
        Hyderabad, India | priyanshu.das@live.com | 
        <a href="https://linkedin.com" color="blue">LinkedIn</a> | 
        <a href="https://github.com" color="blue">GitHub</a>
    </font>
</para>
"""
story.append(Paragraph(header_sub, styles['Normal']))
story.append(Spacer(1, 0.1 * inch))

# --- Professional Summary ---
story.append(Paragraph("Professional Summary", styles['SecHeader']))
story.append(HRFlowable(width="100%", thickness=1, color=colors.HexColor('#1f4e79'), spaceAfter=6))
summary_text = (
    "Strategic Software Architect with 14+ years of expertise in the Java ecosystem. Specialist in high-concurrency "
    "distributed systems, having delivered mission-critical platforms with 99.99% uptime and sub-100ms latency. "
    "Expert in driving engineering excellence through ADRs, TDD, and automated CI/CD guardrails."
)
story.append(Paragraph(summary_text, styles['Txt']))

# --- Technical Skills (ATS Optimized) ---
story.append(Paragraph("Technical Skills", styles['SecHeader']))
story.append(HRFlowable(width="100%", thickness=1, color=colors.HexColor('#1f4e79'), spaceAfter=6))
skills_data = [
    [Paragraph("<b>Languages & Runtime:</b> Java 21 (Virtual Threads, ZGC), Node.js, SQL, TypeScript", styles['Txt']),
     Paragraph("<b>Cloud & DevOps:</b> Docker, Kubernetes, AWS, Jenkins, Terraform, ELK Stack", styles['Txt'])],
    [Paragraph("<b>Distributed Systems:</b> Kafka, Redis, Debezium, Event-Driven Architecture", styles['Txt']),
     Paragraph("<b>Architecture:</b> Microservices, Outbox/CDC Patterns, Hexagonal Architecture", styles['Txt'])]
]
skills_table = Table(skills_data, colWidths=[3.5 * inch, 3.5 * inch])
skills_table.setStyle(TableStyle([('VALIGN', (0, 0), (-1, -1), 'TOP')]))
story.append(skills_table)

# --- Professional Experience ---
story.append(Paragraph("Professional Experience", styles['SecHeader']))
story.append(HRFlowable(width="100%", thickness=1, color=colors.HexColor('#1f4e79'), spaceAfter=6))

# Techmojo
story.append(Paragraph("<b>TECHMOJO SOLUTIONS</b> | Member of Technical Staff (Architect)", styles['SubHeader']))
story.append(Paragraph("""
• <b>Architectural Design:</b> Engineered a mission-critical Player Account Management system using the Transactional Outbox pattern, achieving 99.99% uptime and sub-100ms sync latency.<br/>
• <b>Performance Tuning:</b> Optimized JVM/ZGC and Redis caching, resulting in a <b>45% reduction in DB IOPS</b> and stabilized throughput during peak traffic.<br/>
• <b>Leadership:</b> Directed engineering strategy for 3 cross-functional squads; authored 10+ ADRs that standardized resilient design patterns across the organization.
""", styles['Txt']))

# Reputation
story.append(Paragraph("<b>REPUTATION.COM</b> | Lead Engineer", styles['SubHeader']))
story.append(Paragraph("""
• <b>Event-Driven Migration:</b> Re-architected legacy flows to Kafka-based streams, improving system responsiveness by 60% and enabling real-time business analytics.<br/>
• <b>Operational Excellence:</b> Implemented automated SonarQube quality gates in CI/CD pipelines, <b>reducing production defects by 30%</b> within the first year.<br/>
• <b>UI/UX Architecture:</b> Led Angular dashboard development, utilizing reactive state management to improve data visualization rendering efficiency by 40%.
""", styles['Txt']))

# Eze Software
story.append(Paragraph("<b>EZE SOFTWARE</b> | Senior Software Engineer", styles['SubHeader']))
story.append(Paragraph("""
• <b>Data Orchestration:</b> Engineered Node.js ingestion services for multi-terabyte financial datasets, ensuring <b>zero data loss</b> during peak transformation windows.<br/>
• <b>Efficiency Gains:</b> Built a Python/MongoDB automation framework that eliminated 20+ hours of manual reporting work per week for the operations team.
""", styles['Txt']))

# Cognizant
story.append(Paragraph("<b>COGNIZANT</b> | Associate Projects", styles['SubHeader']))
story.append(Paragraph("""
• <b>Legacy Optimization:</b> Achieved a <b>40% reduction in API response times</b> by refactoring complex SQL procedures and implementing strategic Oracle indexing.<br/>
• <b>Quality Engineering:</b> Spearheaded TDD adoption for global banking modules, maintaining a consistent 90%+ code coverage.<br/>
• <b>Agile Delivery:</b> Facilitated sprint planning and peer reviews to ensure high-quality delivery for mission-critical financial systems.
""", styles['Txt']))

# --- Projects ---
story.append(Paragraph("Key Projects", styles['SecHeader']))
story.append(HRFlowable(width="100%", thickness=1, color=colors.HexColor('#1f4e79'), spaceAfter=6))
story.append(Paragraph("<b>PriCart: E-Commerce Microservices Ecosystem</b>", styles['SubHeader']))
story.append(Paragraph(
    "Designed a high-throughput platform using Java 21 and Spring Boot. Implemented Resilience4j circuit breakers and "
    "Kafka-based event sourcing to handle 5k+ concurrent transactions with automated recovery flows.", styles['Txt']))

# --- Education ---
story.append(Paragraph("Education", styles['SecHeader']))
story.append(HRFlowable(width="100%", thickness=1, color=colors.HexColor('#1f4e79'), spaceAfter=6))
edu_data = [
    [Paragraph("<b>M.Tech, Applied Software Engineering</b>", styles['SubHeader']), Paragraph("Woolf University / Scaler Neoversity (2026)", styles['Txt'])],
    [Paragraph("<b>B.Tech, Electronics & Communication</b>", styles['SubHeader']), Paragraph("Graduated 2010", styles['Txt'])]
]
edu_table = Table(edu_data, colWidths=[4.5 * inch, 2.5 * inch])
story.append(edu_table)

# Build the PDF
try:
    doc.build(story)
    print(f"Successfully generated Final ATS-Optimized Resume at: {out}")
except Exception as e:
    print(f"Error: {e}")