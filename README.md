# Semgrep Rules for Android Application Security

[![Owasp-MASTG](https://img.shields.io/badge/OWASP_MASTG-v1.5.0-blue)](https://github.com/OWASP/owasp-mastg/tree/v1.5.0)
[![Semgrep](https://img.shields.io/badge/Semgrep-v1.55.0-orange)](https://semgrep.dev/)

This project is a compilation of [Semgrep](https://semgrep.dev/) rules derived from the OWASP Mobile Application Security Testing Guide ([MASTG](https://mas.owasp.org/MASTG/)) specifically for Android applications.  
The aim is to enhance and support Mobile Application Penetration Testing (MAPT) activities conducted by the ethical hacker community.
The primary objective of these rules is to address the static tests outlined in the OWASP MASTG. Consequently, dynamic tests are considered out of this project scope.  
These rules are designed from the perspective of a penetration tester and do not include checks related to configuration files that are not usually embedded in the Android App Package (APK), such as the "build.gradle" file.
The intended source code for analysis using these Semgrep rules is the decompiled code from the target APK.

_Why Semgrep?_  
Semgrep stands out as a powerful static analysis tool utilized for identifying specific patterns within the target source code. With its self-explanatory syntax, it offers multiple mechanisms to conduct thorough intra-file analysis. Semgrep is an open source project and offers patterns to conduct taint analysis, source code recognition, variable comparison and string heuristics on a large set of programming languages. Importantly, it eliminates the requirement of uploading source code to cloud platforms.  
Thanks to these features, Semgrep is highly suitable for Static Application Security Testing (SAST) activities.  

### Installation & Usage :wrench:  
First, install Semgrep CLI with the following command ([installation guide](https://semgrep.dev/docs/getting-started/)):
```bash
# For Ubuntu/WSL/Linux/macOS
$ python3 -m pip install semgrep
```

Extract and scan the target source code using [JADX](https://github.com/skylot/jadx):

```bash
# Download the target APK and the rules of the current project 
$ ls
target.apk semgrep_for_android/
# Retrieve the source code from the APK file
$ jadx -d target_src target.apk
# To use the .semgrepignore file launch the scan from the project folder
$ cd semgrep_for_android/
# Run Semgrep with the new security rules
$ semgrep -c ./rules/ ../target_src/
```

Performance tips:
> _1. Using the entire set of rules on your target code can be computationally expensive. Therefore, it is suggested to scan only the relevant code, e.g. by excluding the code belonging to well-known libraries._  

>_2. Make sure to launch the scan from the project folder in order to use the provided ".semgrepignore" file. This prevents scanning well-known libraries that could generate a high number of false positives._

### Project Status :checkered_flag:
The rules are aligned with the version [1.5.0](https://github.com/OWASP/owasp-mastg/tree/v1.5.0) of the OWASP MASTG. While complete coverage of all tests cannot be guaranteed, the authors have made significant efforts to provide a comprehensive overview of the status of each implemented rule.  
The presence of False Positives (FP) is expected but limited and efforts have been done to reduce the potential occurrence of False Negatives (FN).

The grade of maturity and the reliability of each rule has been classified according to the following categories:  
:heavy_check_mark: Complete: the rule is highly reliable, although there may be some false positives.  
:thumbsup: Good: the rule is reliable but there may be false negatives.  
:broken_heart: Partial: the rule does not sufficiently cover all static tests.  
:sweat_smile: Tentative: the rule is based on a generous simplification of the static tests.  
:x: Infeasible: the rule can not be implemented with the current free version of Semgrep.  

For further information about the status of each rule, it is possible to visit the [**STATUS PAGE**](./status.md).

### Limitations :raised_hands:  
Semgrep is a well-supported and continuously improved tool but the current free version is not devoid of limitations. The most significant one, discovered during the implementation of this project, is the inability to check for the absence of a pattern in a multi-file source code. As a result, it is not possible to verify the presence of a specific protection without first selecting the specific file that should contain the searched protection.  
For these reasons, the category "resilience" of the MASTG has been omitted from the initial versions of the current project.  
_(Visit the link for further information: https://github.com/returntocorp/semgrep/issues/7363)_  

Moreover, the rules that requires a specific knowledge of the application context have been classified as "Infeasible" since the current project is designed to be used automatically. For example, it is not possible to discern if a specific link is external from the application infrastructure or not.

### Authors & Contributors :beers: :it:  
The project was started in March 2023 by the [**IMQ Minded Security**](https://mindedsecurity.com/) team with the purpose to contribute to the ethical hacking and mobile development communities. The company has an ongoing commitment to make customers aware of cyber risks supporting businesses and organizations to build secure products and services.  
The contribution to this project is totally open with the recommendation to be careful in submitting rules that respect the proposed format.
- Supervisor: Stefano Di Paola ([@WisecWisec](https://twitter.com/WisecWisec))
- Project leader: Riccardo Cardelli ([@gand3lf](https://github.com/gand3lf))
- Contributors: Andrea Agnello (@AndreNoli), Christian Cotignola (@b4dsheep), Federico Dotta (@apps3c), Giacomo Zorzin (@gellge), Giovanni Fazi (@giovifazi), Martino Lessio (@mlessio), Maurizio Siddu (@akabe1), Michele Di Bonaventura (@cyberaz0r), Michele Tumolo (@zer0s0urce), Riccardo Granata (@riccardogranata)

### Talks & More :microphone:
- 23 Oct 2023: IMQ Minded Security Blog ([Project's Official Article](https://blog.mindedsecurity.com/2023/10/semgrep-rules-for-android-application.html))  
- 11 Sep 2023: OWASP Italy Day ([Slides](https://github.com/OWASP/www-chapter-italy/blob/96201991fdfef280a67d3b41b85e7715d53115d8/assets/images/Riccardo%20Cardelli%20-%20OWASP%20Italy%20Day%202023%20-%2011th%20Sept%20PoliMi.pdf))
- 03 Ago 2023: DevSecCon - Introduzione a SAST e Mobile Security Testing ([YouTube Live](https://youtu.be/ZsZMzGD9-6E))  
