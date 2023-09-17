# Contributing Guide
Thank you for the time you choose to dedicate for contributing to our project!
The contribution to this rules collection is totally open with the recommendation to be careful in submitting rules that respect the proposed format and the following guidelines.
We are always committed to ensuring that the project remains a professional tool that can be used by industry experts.

## General Guidelines
1. It is suggested to submit a single pull request for each proposed change, such as new rules, updates, or typo fixes for implemented rules.
2. Custom naming convention should be avoided avoided in both the rules and the code. If you would like to propose a new nomenclature, please open a Github issue.
The correct naming convention is the following:
    - filename -> mstg-\<area\>-\<version\>.\<extension\>
    - rule ID -> MSTG-\<AREA\>-\<version\>  

For example:
```
    - mstg-code-1.yaml   (test file: mstg-code-1.java)   - id: MSTG-CODE-1  
    - mstg-code-2.1.yaml (test file: mstg-code-2.1.java) - id: MSTG-CODE-2.1  
    - mstg-code-2.2.yaml (test file: mstg-code-2.2.java) - id: MSTG-CODE-2.2  
    - mstg-code-2.3.yaml (test file: mstg-code-2.3.xml)  - id: MSTG-CODE-2.3  
```
3. The "message" field should briefly describe the alert. It does not represent an exhaustive description of the vulnerability. Moreover, each message should follow the most common technical writing rules, avoiding abbreviations, jargon, and vague language.
4. The project goal does not involve generating a large number of false positives that are subsequently reviewed by the tester. Rather, the goal is to find a balance that minimizes both false positives and false negatives, maximizing the reliability of each rule.
5. It is recommended to avoid including tests that are not described in the testing guide.
6. Each submitted pull requests should target the development branch. The rules in this branch are periodically stress tested and then pushed to the main branch.
7. Please do not remove the names of other contributors from the specific rule. If you are unsure, append your name to the list of contributors in the rule field "authors".
8. In this version of the project, it is recommended to contribute by considering exclusively the MSTG tests listed in the [STATUS](https://github.com/mindedsecurity/semgrep-rules-android-security/blob/main/status.md) page. It contains the list of the specific Android tests that are currently in the scope of this project.
9. In the pull request description, please indicate whether the rule categorization should be changed after the proposed changes.

<div align=center>
:beers: <b>Thank you!</b> :beers:
</div>
