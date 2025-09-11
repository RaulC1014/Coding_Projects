import javax.swing.JOptionPane;
import java.util.*;

public class game {

    static class Q {
        final String prompt;
        final String[] choices;
        final int correctIdx; 
        final String explanation;

        Q(String prompt, String[] choices, int correctIdx, String explanation) {
            this.prompt = prompt;
            this.choices = choices;
            this.correctIdx = correctIdx;
            this.explanation = explanation;
        }
    }

    public static void main(String[] args) {
        
        List<Q> bank = new ArrayList<>(Arrays.asList(
            new Q(
                "Which best describes the Principle of Least Privilege?",
                new String[]{
                    "Give users only the permissions they need to do their job",
                    "Give admins full access to everything by default",
                    "Block all access until a ticket is opened"
                },
                0,
                "Least privilege = minimum permissions required to perform tasks."
            ),
            new Q(
                "Which is NOT a common factor in multi-factor authentication (MFA)?",
                new String[]{
                    "Something you know (password/PIN)",
                    "Something you have (token/phone)",
                    "Something you are (biometrics)",
                    "Something you like (favorite color)"
                },
                3,
                "MFA factors are knowledge, possession, and inherence—not preferences."
            ),
            new Q(
                "The safest way to handle a suspicious email asking you to reset your password is to:",
                new String[]{
                    "Click the link quickly before it expires",
                    "Reply asking if it’s legitimate",
                    "Delete it immediately without reporting",
                    "Navigate directly to the site yourself or contact support via a known channel"
                },
                3,
                "Avoid links in unsolicited emails—go to the site manually or use official contacts."
            ),
            new Q(
                "Which password is strongest?",
                new String[]{
                    "P@ssw0rd!",
                    "Tr0ub4dor&3",
                    "Sunset1999",
                    "cow-lake-battery-laptop (a long passphrase)"
                },
                3,
                "Length beats clever substitutions—long passphrases are stronger and easier to remember."
            ),
            new Q(
                "What is the primary purpose of HTTPS/TLS?",
                new String[]{
                    "Compress pages for faster load",
                    "Encrypt traffic and authenticate the server",
                    "Block pop-ups",
                    "Improve SEO ranking"
                },
                1,
                "TLS provides encryption in transit and server authentication via certificates."
            ),
            new Q(
                "Which BEST mitigates SQL Injection?",
                new String[]{
                    "Client-side form validation only",
                    "Parameterized (prepared) statements",
                    "Hiding database error messages",
                    "Storing queries in environment variables"
                },
                1,
                "Use parameterized queries—never concatenate untrusted input into SQL."
            ),
            new Q(
                "XSS (Cross-Site Scripting) defenses should primarily focus on:",
                new String[]{
                    "Strong passwords",
                    "Output encoding and input validation",
                    "Blocking all cookies",
                    "Using long URLs"
                },
                1,
                "Encode untrusted data on output and validate input to prevent script injection."
            ),
            new Q(
                "A security patch is released for a critical vulnerability. What’s best practice?",
                new String[]{
                    "Wait a few months to avoid instability",
                    "Apply it promptly after testing",
                    "Ignore it if you have a firewall",
                    "Apply only on developer laptops"
                },
                1,
                "Apply critical patches promptly after verification to reduce exposure."
            ),
            new Q(
                "Which backup strategy offers the BEST resilience against ransomware?",
                new String[]{
                    "Backups on the same machine",
                    "Cloud backups only",
                    "Offline/immutable backups with tested restores",
                    "Emailing zip files to yourself"
                },
                2,
                "Offline or immutable backups + regular restore tests = ransomware resilience."
            ),
            new Q(
                "Which is the safest way to share passwords within a team?",
                new String[]{
                    "Send in a chat message",
                    "Use a shared password manager with access controls",
                    "Put in a shared spreadsheet",
                    "Write on a whiteboard near the team area"
                },
                1,
                "Use a vetted password manager with proper access control and auditing."
            ),
            new Q(
                "What’s a good first response if your account may be compromised?",
                new String[]{
                    "Ignore it until you’re sure",
                    "Change your password and review sessions/2FA settings",
                    "Delete the account immediately",
                    "Post about it on social media"
                },
                1,
                "Rotate credentials, check active sessions/devices, and ensure MFA is enabled."
            ),
            new Q(
                "Phishing vs. Spear-phishing: spear-phishing is:",
                new String[]{
                    "Random emails to many recipients",
                    "Targeted emails tailored to a specific person/org",
                    "Phone calls pretending to be IT",
                    "Malware attached to USB drives"
                },
                1,
                "Spear-phishing is targeted and personalized to increase credibility."
            ),
            new Q(
                "Which header helps mitigate clickjacking?",
                new String[]{
                    "X-Frame-Options / Content-Security-Policy frame-ancestors",
                    "X-Powered-By",
                    "ETag",
                    "Server"
                },
                0,
                "Use X-Frame-Options or CSPs frame-ancestors to control framing."
            ),
            new Q(
                "Which is the BEST description of zero trust?",
                new String[]{
                    "Trust anything inside the network perimeter",
                    "Grant long-lived standing access",
                    "Never trust, always verify (continuous authentication/authorization)",
                    "Disable MFA to reduce friction"
                },
                2,
                "Zero trust continuously verifies identity, device health, and context."
            ),
            new Q(
                "A good phishing indicator is:",
                new String[]{
                    "Flawless grammar and spelling",
                    "Unexpected urgency, mismatched domains, or unusual requests",
                    "Using your proper name",
                    "An attachment you were expecting"
                },
                1,
                "Urgency + domain mismatches + odd requests often signal phishing."
            ),
            new Q(
                "The BEST way to store API keys in an app is:",
                new String[]{
                    "Hard-code them in source",
                    "Commit them to a private repo",
                    "Use environment variables / secret manager",
                    "Bundle them in the client app"
                },
                2,
                "Use env vars or a secret manager; never commit secrets to code or ship to clients."
            ),
            new Q(
                "Which control helps prevent data exfiltration from a lost laptop?",
                new String[]{
                    "Screen saver",
                    "Full-disk encryption",
                    "Desktop wallpaper warning",
                    "Dark mode"
                },
                1,
                "Full-disk encryption protects data at rest if a device is lost or stolen."
            ),
            new Q(
                "Which statement about security logging is MOST accurate?",
                new String[]{
                    "Logs are optional in production",
                    "Logs should be centrally collected and monitored",
                    "Only errors need logging",
                    "Logs should include full passwords for debugging"
                },
                1,
                "Centralized, monitored logs enable detection, investigation, and response."
            ),
            // --- Security+ focused additions ---

            new Q(
                "Which port does HTTPS use by default?",
                new String[]{"443", "80", "22", "3389"},
                0,
                "HTTPS uses TCP 443. HTTP uses 80, SSH uses 22, RDP uses 3389."
            ),
            new Q(
                "Which wireless standard uses SAE to replace WPA2-PSK and improve resistance to offline cracking?",
                new String[]{"WPA3-Personal", "WPA2-Enterprise", "WEP", "Open (no auth)"},
                0,
                "WPA3-Personal uses Simultaneous Authentication of Equals (SAE) to resist offline attacks."
            ),
            new Q(
                "Which standard enables web SSO using XML-based assertions?",
                new String[]{"SAML", "OAuth 2.0", "OpenID Connect", "RADIUS"},
                0,
                "SAML provides federated SSO via assertions. OAuth 2.0 is delegated authZ; OIDC adds identity on OAuth."
            ),
            new Q(
                "Which key exchange provides Perfect Forward Secrecy (PFS)?",
                new String[]{"ECDHE", "Static RSA", "Static DH", "Pre-shared key"},
                0,
                "Ephemeral Diffie-Hellman (ECDHE) creates new session keys, enabling PFS."
            ),
            new Q(
                "What best mitigates rainbow table attacks against stored passwords?",
                new String[]{
                    "Use salted, slow hashes (bcrypt/scrypt/Argon2)",
                    "Encrypt passwords with AES-256",
                    "Hash once with unsalted SHA-256",
                    "Store in a private repo only"
                },
                0,
                "Unique salts + deliberately slow KDFs defeat precomputed tables and raise cracking cost."
            ),
            new Q(
                "Which BEST describes a vulnerability scan?",
                new String[]{
                    "Non-intrusive identification of known issues and misconfigurations",
                    "Exploitation of weaknesses to prove impact",
                    "Disabling controls to observe attacker behavior",
                    "Performing a red team exercise"
                },
                0,
                "Vuln scans enumerate and prioritize weaknesses; penetration tests attempt exploitation."
            ),
            new Q(
                "Which control actively blocks malicious traffic inline?",
                new String[]{"IPS", "IDS", "SIEM", "SOAR"},
                0,
                "An IPS is inline and can block; an IDS is out-of-band and alerts."
            ),
            new Q(
                "Which is a physical security control?",
                new String[]{"Mantrap", "Antivirus", "WAF", "Disk encryption"},
                0,
                "Mantraps, turnstiles, and guards are physical controls."
            ),
            new Q(
                "What does DKIM provide for email?",
                new String[]{"Domain-linked message integrity via cryptographic signatures", "End-to-end content encryption", "Spam classification", "Mailbox quotas"},
                0,
                "DKIM signs messages so recipients can verify domain authenticity and integrity."
            ),
            new Q(
                "Which method checks certificate revocation with minimal client privacy leakage?",
                new String[]{"OCSP stapling", "CRL download", "HSTS", "Certificate pinning"},
                0,
                "OCSP stapling lets the server attach a fresh OCSP response, avoiding per-client CA lookups."
            ),
            new Q(
                "Which EAP method requires a client certificate for mutual authentication?",
                new String[]{"EAP-TLS", "PEAP (MSCHAPv2)", "EAP-FAST", "PAP"},
                0,
                "EAP-TLS uses client and server certificates for strong mutual auth."
            ),
            new Q(
                "Redirecting users via a poisoned DNS cache is known as:",
                new String[]{"Pharming (DNS poisoning)", "Vishing", "Tailgating", "Credential stuffing"},
                0,
                "Pharming manipulates DNS to redirect to malicious sites."
            ),
            new Q(
                "Which network defense helps prevent ARP spoofing?",
                new String[]{"Dynamic ARP Inspection (DAI)", "Port mirroring", "NAT", "STP"},
                0,
                "DAI validates ARP replies using trusted bindings (often from DHCP snooping)."
            ),
            new Q(
                "A SIEM primarily provides:",
                new String[]{
                    "Centralized log collection, correlation, alerting, and dashboards",
                    "Automatic incident containment playbooks",
                    "Inline packet blocking",
                    "Patch deployment"
                },
                0,
                "SIEMs aggregate and correlate logs; SOAR tools automate response playbooks."
            ),
            new Q(
                "During the ERADICATION phase of incident response, which action is MOST appropriate?",
                new String[]{"Remove malware and close exploited vulnerabilities", "Restore systems to production", "Detect the incident", "Write the after-action report"},
                0,
                "Eradication removes root cause and cleans systems; recovery comes after."
            ),
            new Q(
                "ALE in risk calculations equals:",
                new String[]{"SLE × ARO", "SLE + ARO", "MTTR ÷ MTBF", "RPO × RTO"},
                0,
                "Annualized Loss Expectancy = Single Loss Expectancy × Annualized Rate of Occurrence."
            ),
            new Q(
                "RPO (Recovery Point Objective) defines:",
                new String[]{
                    "Max acceptable data loss measured in time",
                    "Max acceptable outage duration",
                    "Mean time to repair",
                    "Frequency of backup tests"
                },
                0,
                "RPO is the time-based tolerance for data loss (e.g., 4 hours of data)."
            ),
            new Q(
                "In which cloud model does the vendor manage the application and underlying stack?",
                new String[]{"SaaS", "IaaS", "PaaS", "On-prem"},
                0,
                "With SaaS, the provider runs the app; customers handle data/config and access."
            ),
            new Q(
                "Compared to a traditional VPN, ZTNA primarily:",
                new String[]{
                    "Grants per-app access by default deny, continuously verified",
                    "Creates full network access once connected",
                    "Requires split tunneling",
                    "Relies on static IP allowlists only"
                },
                0,
                "Zero Trust Network Access minimizes lateral movement with per-app least-privilege."
            ),
            new Q(
                "Which BEST describes stored (persistent) XSS?",
                new String[]{
                    "Malicious input is saved by the server and delivered to future users",
                    "Attack uses a one-time reflected response only",
                    "It requires CSRF tokens to succeed",
                    "It only works over HTTP, not HTTPS"
                },
                0,
                "Stored XSS persists on the server (e.g., in a comment) and affects multiple users."
            ),
            new Q(
                "What does a file integrity monitoring (FIM) system do?",
                new String[]{
                    "Detects unexpected changes to critical files via cryptographic hashes",
                    "Blocks all untrusted executables",
                    "Encrypts files at rest",
                    "Backs up files to cold storage"
                },
                0,
                "FIM tools compare current hashes to baselines and alert on changes."
            ),
            new Q(
                "Why is time synchronization (e.g., NTP) important for security operations?",
                new String[]{
                    "Accurate log correlation and certificate validity checks",
                    "Faster Wi-Fi roaming",
                    "Lower CPU usage",
                    "Better compression ratios"
                },
                0,
                "Consistent timestamps enable reliable investigations and TLS certificate validation."
            ),
            new Q(
                "Network segmentation using VLANs primarily helps to:",
                new String[]{
                    "Limit broadcast domains and reduce lateral movement",
                    "Increase signal strength",
                    "Encrypt L2 traffic by default",
                    "Eliminate the need for firewalls"
                },
                0,
                "VLANs separate segments to improve performance and security."
            ),
            new Q(
                "Which protocol enforces port-based network access control?",
                new String[]{"802.1X", "LLDP", "NAC using SNMPv1", "TFTP"},
                0,
                "802.1X authenticates devices/users before granting switch port access."
            ),
            new Q(
                "Which control prevents sensitive documents from leaving via email or USB?",
                new String[]{"DLP", "DRM", "NAT", "EFS"},
                0,
                "DLP monitors and blocks exfiltration; DRM controls usage of distributed files."
            ),
            new Q(
                "What is the MOST appropriate sanitization method for SSDs?",
                new String[]{"Cryptographic erase (destroy keys)", "Degaussing", "Single overwrite", "Low-level format"},
                0,
                "SSDs are best sanitized by destroying encryption keys (crypto erase)."
            ),
            new Q(
                "Security awareness training is which type of control?",
                new String[]{"Administrative", "Technical", "Physical", "Compensating only"},
                0,
                "Policies, procedures, and training are administrative controls."
            ),
            new Q(
                "Which protocol secures directory queries and binds?",
                new String[]{"LDAPS (TCP 636)", "LDAP (TCP 389) in cleartext", "Telnet", "POP3"},
                0,
                "LDAPS wraps LDAP in TLS on 636; StartTLS can also secure LDAP on 389."
            ),
            new Q(
                "Which wireless setting should you disable to avoid easy PIN brute forcing?",
                new String[]{"WPS", "WMM", "MIMO", "MU-MIMO"},
                0,
                "Wi-Fi Protected Setup (WPS) PIN mode is vulnerable to brute forcing."
            ),
            new Q(
                "Which protocol combination provides email domain authentication and policy enforcement?",
                new String[]{
                    "SPF + DKIM + DMARC",
                    "POP3 + IMAP",
                    "FTP + TFTP",
                    "S/MIME + PGP"
                },
                0,
                "SPF authorizes senders, DKIM signs mail, DMARC aligns and enforces policy."
            )

        ));

        while (true) {
            JOptionPane.showMessageDialog(
                null,
                "Welcome! Let's play a 10-question Security Quiz.\nChoose the best answer from the dropdown.",
                "Security Quiz",
                JOptionPane.PLAIN_MESSAGE
            );

            
            Collections.shuffle(bank, new Random());
            List<Q> quiz = bank.subList(0, Math.min(10, bank.size()));

            int score = 0;
            int qNum = 1;

            for (Q q : quiz) {
                
                Object selection = JOptionPane.showInputDialog(
                    null,
                    qNum + ". " + q.prompt,
                    "Question " + qNum,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    q.choices,
                    q.choices[0]
                );

                if (selection == null) {
                    int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Do you want to quit the quiz?",
                        "Quit?",
                        JOptionPane.YES_NO_OPTION
                    );
                    if (confirm == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Goodbye!", "Exit", JOptionPane.PLAIN_MESSAGE);
                        System.exit(0);
                    } else {
                        // Re-ask the same question
                        continue;
                    }
                }

                int chosenIdx = Arrays.asList(q.choices).indexOf(selection.toString());
                boolean correct = (chosenIdx == q.correctIdx);
                if (correct) score++;

                String feedbackTitle = correct ? "Correct!" : "Incorrect";
                String feedbackMsg =
                    (correct ? " Correct!\n" : " Incorrect.\n") +
                    "Answer: " + q.choices[q.correctIdx] + "\n\n" +
                    "Why: " + q.explanation;

                JOptionPane.showMessageDialog(
                    null,
                    feedbackMsg,
                    feedbackTitle,
                    JOptionPane.PLAIN_MESSAGE
                );

                qNum++;
            }

            JOptionPane.showMessageDialog(
                null,
                "You scored " + score + " out of " + quiz.size() + "!\n" +
                (score == quiz.size() ? "🎉 Perfect!" : (score >= 8 ? " Great job!" : " Keep practicing!")),
                "Results",
                JOptionPane.PLAIN_MESSAGE
            );

            int again = JOptionPane.showConfirmDialog(
                null,
                "Play again with a new random set?",
                "Play Again?",
                JOptionPane.YES_NO_OPTION
            );
            if (again != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Thanks for playing!", "Bye!", JOptionPane.PLAIN_MESSAGE);
                break;
            }
        }
    }
}
