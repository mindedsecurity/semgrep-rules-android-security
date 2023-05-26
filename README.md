# Semgrep rules for Android Application Security

[![Owasp-MASTG](https://img.shields.io/badge/OWASP_MASTG-v1.5.0-blue)](https://github.com/OWASP/owasp-mastg/tree/v1.5.0)
[![Semgrep](https://img.shields.io/badge/Semgrep-v1.17.1-green)](https://semgrep.dev/)
[![License](https://img.shields.io/badge/License-GPL3.0-orange)](https://www.gnu.org/licenses/gpl-3.0.html)

This project is a compilation of [Semgrep](https://semgrep.dev/) rules derived from the OWASP Mobile Application Security Testing Guide ([MASTG](https://mas.owasp.org/MASTG/)) specifically for Android applications.  
The aim is to enhance and support Mobile Application Penetration Testing (MAPT) activities conducted by the ethical hacker community.
The primary objective of these rules is to address the static tests outlined in the OWASP MASTG. Consequently, dynamic tests are considered out of this project scope.  
These rules are designed from the perspective of a penetration tester and do not include checks related to configuration files that are not usually embedded in the Android App Package (APK), such as the "build.gradle" file.
The intended source code for analysis using these Semgrep rules is the decompiled code from the target APK.

_Why Semgrep?_  
Semgrep stands out as a powerful static analysis tool utilized for identifying specific patterns within the target source code. With its self-explanatory syntax, it offers multiple mechanisms to conduct thorough intra-file analysis. Semgrep is an open source project and offers patterns to conduct taint analysis, source code recognition, variable comparison and string heuristics on a large set of programming languages. Importantly, it eliminates the requirement of uploading source code to cloud platforms.  
Thanks to these features, Semgrep is highly suitable for Static Application Security Testing (SAST) activities.  

_What is the project status?_  
The rules are aligned with the version [1.5.0](https://github.com/OWASP/owasp-mastg/tree/v1.5.0) of the OWASP MASTG. While complete coverage of all tests cannot be guaranteed, the authors have made significant efforts to provide a comprehensive overview of the status of each implemented rule.  
The presence of False Positives (FP) is expected but limited and efforts have been done to reduce the potential occurrence of False Negatives (FN).

The grade of maturity and the reliability of each rule has been classified according to the following categories:  
:heavy_check_mark: Complete: the rule is highly reliable, although there may be some false positives.  
:thumbsup: Good: the rule is reliable but there may be false negatives.  
:broken_heart: Partially: the rule does not sufficiently cover all static tests.  
:sweat_smile: Tentative: the rule is based on a generous simplification of the static tests.  
:x: Infeasible: the rule can not be implemented with Semgrep.  

| MASVS-ID           | Requirement                                                                                                                                                                                                                              | L1/L2/R | Status     |
| ------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------- | ---------- |
| MSTG-ARCH-9        | A mechanism for enforcing updates of the mobile app exists.                                                                                                                                                                              | L2      | TODO       |
| MSTG-STORAGE-1     | System credential storage facilities need to be used to store sensitive data, such as PII, user credentials or cryptographic keys.                                                                                                       | L1      | TODO       |
| MSTG-STORAGE-2     | No sensitive data should be stored outside of the app container or system credential storage facilities.                                                                                                                                 | L1      | TODO       |
| MSTG-STORAGE-3     | No sensitive data is written to application logs.                                                                                                                                                                                        | L1      | TODO       |
| MSTG-STORAGE-4     | No sensitive data is shared with third parties unless it is a necessary part of the architecture.                                                                                                                                        | L1      | TODO       |
| MSTG-STORAGE-5     | The keyboard cache is disabled on text inputs that process sensitive data.                                                                                                                                                               | L1      | TODO       |
| MSTG-STORAGE-6     | No sensitive data is exposed via IPC mechanisms.                                                                                                                                                                                         | L1      | TODO       |
| MSTG-STORAGE-7     | No sensitive data, such as passwords or pins, is exposed through the user interface.                                                                                                                                                     | L1      | TODO       |
| MSTG-STORAGE-8     | No sensitive data is included in backups generated by the mobile operating system.                                                                                                                                                       | L2      | TODO       |
| MSTG-STORAGE-9     | The app removes sensitive data from views when moved to the background.                                                                                                                                                                  | L2      | TODO       |
| MSTG-STORAGE-10    | The app does not hold sensitive data in memory longer than necessary, and memory is cleared explicitly after use.                                                                                                                        | L2      | TODO       |
| MSTG-STORAGE-11    | The app enforces a minimum device-access-security policy, such as requiring the user to set a device passcode.                                                                                                                           | L2      | TODO       |
| MSTG-CRYPTO-1      | The app does not rely on symmetric cryptography with hardcoded keys as a sole method of encryption.                                                                                                                                      | L1      | TODO       |
| MSTG-CRYPTO-2      | The app uses proven implementations of cryptographic primitives.                                                                                                                                                                         | L1      | TODO       |
| MSTG-CRYPTO-3      | The app uses cryptographic primitives that are appropriate for the particular use-case, configured with parameters that adhere to industry best practices.                                                                               | L1      | TODO       |
| MSTG-CRYPTO-4      | The app does not use cryptographic protocols or algorithms that are widely considered deprecated for security purposes.                                                                                                                  | L1      | TODO       |
| MSTG-CRYPTO-5      | The app doesn't re-use the same cryptographic key for multiple purposes.                                                                                                                                                                 | L1      | TODO       |
| MSTG-CRYPTO-6      | All random values are generated using a sufficiently secure random number generator.                                                                                                                                                     | L1      | TODO       |
| MSTG-AUTH-1        | If the app provides users access to a remote service, some form of authentication, such as username/password authentication, is performed at the remote endpoint.                                                                        | L1      | TODO       |
| MSTG-AUTH-8        | Biometric authentication, if any, is not event-bound (i.e. using an API that simply returns "true" or "false"). Instead, it is based on unlocking the keychain/keystore.                                                                 | L2      | TODO       |
| MSTG-NETWORK-1     | Data is encrypted on the network using TLS. The secure channel is used consistently throughout the app.                                                                                                                                  | L1      | TODO       |
| MSTG-NETWORK-2     | The TLS settings are in line with current best practices, or as close as possible if the mobile operating system does not support the recommended standards.                                                                             | L1      | TODO       |
| MSTG-NETWORK-3     | The app verifies the X.509 certificate of the remote endpoint when the secure channel is established. Only certificates signed by a trusted CA are accepted.                                                                             | L1      | TODO       |
| MSTG-NETWORK-4     | The app either uses its own certificate store, or pins the endpoint certificate or public key, and subsequently does not establish connections with endpoints that offer a different certificate or key, even if signed by a trusted CA. | L2      | TODO       |
| MSTG-NETWORK-6     | The app only depends on up-to-date connectivity and security libraries.                                                                                                                                                                  | L2      | TODO       |
| MSTG-PLATFORM-1    | The app only requests the minimum set of permissions necessary.                                                                                                                                                                          | L1      | TODO       |
| MSTG-PLATFORM-2    | All inputs from external sources and the user are validated and if necessary sanitized. This includes data received via the UI, IPC mechanisms such as intents, custom URLs, and network sources.                                        | L1      | TODO       |
| MSTG-PLATFORM-3    | The app does not export sensitive functionality via custom URL schemes, unless these mechanisms are properly protected.                                                                                                                  | L1      | TODO       |
| MSTG-PLATFORM-4    | The app does not export sensitive functionality through IPC facilities, unless these mechanisms are properly protected.                                                                                                                  | L1      | TODO       |
| MSTG-PLATFORM-5    | JavaScript is disabled in WebViews unless explicitly required.                                                                                                                                                                           | L1      | TODO       |
| MSTG-PLATFORM-6    | WebViews are configured to allow only the minimum set of protocol handlers required (ideally, only https is supported). Potentially dangerous handlers, such as file, tel and app-id, are disabled.                                      | L1      | TODO       |
| MSTG-PLATFORM-7    | If native methods of the app are exposed to a WebView, verify that the WebView only renders JavaScript contained within the app package.                                                                                                 | L1      | TODO       |
| MSTG-PLATFORM-8    | Object deserialization, if any, is implemented using safe serialization APIs.                                                                                                                                                            | L1      | TODO       |
| MSTG-PLATFORM-9    | The app protects itself against screen overlay attacks. (Android only)                                                                                                                                                                   | L2      | TODO       |
| MSTG-CODE-1        | The app is signed and provisioned with a valid certificate, of which the private key is properly protected.                                                                                                                              | L2      | TODO       |
| MSTG-CODE-2        | The app has been built in release mode, with settings appropriate for a release build (e.g. non-debuggable).                                                                                                                             | L2      | TODO       |
| MSTG-CODE-3        | Debugging symbols have been removed from native binaries.                                                                                                                                                                                | L2      | TODO       |
| MSTG-CODE-4        | Debugging code and developer assistance code (e.g. test code, backdoors, hidden settings) have been removed. The app does not log verbose errors or debugging messages.                                                                  | L2      | TODO       |
| MSTG-CODE-5        | All third party components used by the mobile app, such as libraries and frameworks, are identified, and checked for known vulnerabilities.                                                                                              | L2      | TODO       |
| MSTG-CODE-6        | The app catches and handles possible exceptions.                                                                                                                                                                                         | L2      | TODO       |
| MSTG-CODE-7        | Error handling logic in security controls denies access by default.                                                                                                                                                                      | L2      | TODO       |
| MSTG-CODE-8        | In unmanaged code, memory is allocated, freed and used securely.                                                                                                                                                                         | L2      | TODO       |
| MSTG-CODE-9        | Free security features offered by the toolchain, such as byte-code minification, stack protection, PIE support and automatic reference counting, are activated.                                                                          | L2      | TODO       |
| MSTG-RESILIENCE-1  | The app detects, and responds to, the presence of a rooted or jailbroken device either by alerting the user or terminating the app.                                                                                                      | R       | Infeasible |
| MSTG-RESILIENCE-2  | The app prevents debugging and/or detects, and responds to, a debugger being attached. All available debugging protocols must be covered.                                                                                                | R       | Infeasible |
| MSTG-RESILIENCE-3  | The app detects, and responds to, tampering with executable files and critical data within its own sandbox.                                                                                                                              | R       | Infeasible |
| MSTG-RESILIENCE-4  | The app detects, and responds to, the presence of widely used reverse engineering tools and frameworks on the device.                                                                                                                    | R       | Infeasible |
| MSTG-RESILIENCE-5  | The app detects, and responds to, being run in an emulator.                                                                                                                                                                              | R       | Infeasible |
| MSTG-RESILIENCE-6  | The app detects, and responds to, tampering the code and data in its own memory space.                                                                                                                                                   | R       | Infeasible |
| MSTG-RESILIENCE-9  | Obfuscation is applied to programmatic defenses, which in turn impede de-obfuscation via dynamic analysis.                                                                                                                               | R       | Infeasible |
| MSTG-RESILIENCE-10 | The app implements a 'device binding' functionality using a device fingerprint derived from multiple properties unique to the device.                                                                                                    | R       | Infeasible |


### Installation & Usage :wrench:  
First, install Semgrep CLI with one of the following commands([installation guide](https://semgrep.dev/docs/getting-started/)):
```bash
# For macOS
$ brew install semgrep

# For Ubuntu/WSL/Linux/macOS
$ python3 -m pip install semgrep

# To try Semgrep without installation run via Docker
$ docker run --rm -v "${PWD}:/src" returntocorp/semgrep semgrep
```

Extract and analize the target source code using [JADX](https://github.com/skylot/jadx):

```bash
# Download the target APK and the rules of the current project 
$ ls
target.apk semgrep_for_android/
# Retrieve the source code from the APK file
$ jadx -d target_src target.apk
# Run Semgrep with the new security rules
$ semgrep -c semgrep_for_android/rules/ target_src/
```

_Performance tip: Using the entire set of rules on your target code can be computationally expensive. Therefore, it is suggested to scan only the relevant code, e.g. by excluding the code belonging to well-known libraries._

### Limitations :raised_hands:  
Semgrep is a well-supported and continuously improved tool but it is not free from limitations. The most significant one, discovered during the implementation of this project, is the inability to check for the absence of a pattern in a multi-file source code. As a result, it is not possible to verify the presence of a specific protection without first selecting the specific file that should contain the searched protection.  
For these reasons, the category "resilience" of the MASTG has been omitted from the initial versions of the current project.  
_(Visit the link for further information: https://github.com/returntocorp/semgrep/issues/7363)_  

Moreover, the rules that requires a specific knowledge of the application context have been classified as "Infeasible" since the current project is designed to be used automatically. For example, it is not possible to discern if a specific link is external from the application infrastructure or not.

### Authors & Contributors :beers: :it:  
The project was started in March 2023 by the [**IMQ Minded Security**](https://mindedsecurity.com/) team with the purpose to contribute to the ethical hacking and mobile development communities. The company has an ongoing commitment to make customers aware of cyber risks supporting businesses and organizations to build secure products and services.  
The contribution to this project is totally open with the recommendation to be careful in submitting rules that respect the proposed format.

