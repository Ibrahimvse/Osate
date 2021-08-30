/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */

/*
* generated by Xtext
*/
package org.osate.alisa.workbench.ui.quickfix

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.osate.alisa.workbench.alisa.AssurancePlan
import org.osate.alisa.workbench.validation.AlisaValidator
import org.osate.verify.verify.VerificationPlan

/**
 * Custom quickfixes.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
class AlisaQuickfixProvider extends DefaultQuickfixProvider {

//	@Fix(MyDslValidator::INVALID_NAME)
//	def capitalizeName(Issue issue, IssueResolutionAcceptor acceptor) {
//		acceptor.accept(issue, 'Capitalize name', 'Capitalize the name.', 'upcase.png') [
//			context |
//			val xtextDocument = context.xtextDocument
//			val firstLetter = xtextDocument.get(issue.offset, 1)
//			xtextDocument.replace(issue.offset, 1, firstLetter.toUpperCase)
//		]
//	}

	/**
	 * QuickFix for missing assureOwn
	 * The issue data array is expected to have multiple data elements:
	 * issue.getData()[Even]: The name of a missing verification plan
	 * issue.getData()[Odd]: The URI of the missing verification plan named prior
	 */
	@Fix(AlisaValidator.ASSURANCE_PLAN_OWN_MISSING_VERIFICATION_PLANS)
	def public void fixMissingOwnVerificationPlans(Issue issue, IssueResolutionAcceptor acceptor) {
		val names = "'" + issue.getData.indexed().filter([key % 2 == 0]).join("', '", [value]) + "'"
		acceptor.accept(issue, "Add verification plans " + names + " to 'assure'", null, null,
				new ISemanticModification() {
					override apply(EObject element, IModificationContext context) throws Exception {
						val assurancePlan = element as AssurancePlan
						val ResourceSet resourceSet = element.eResource().getResourceSet()
						val uris = issue.getData.indexed().filter([key % 2 == 1])
						uris.forEach([uri |
							assurancePlan.assure.add(resourceSet.getEObject(URI.createURI(uri.value), true) as VerificationPlan)
						])
					}
				});
	}

	/**
	 * QuickFix for invalid verification plans in assureOwn
	 * The issue data array is expected to have multiple data elements:
	 * issue.getData()[Even]: The name of a invalid verification plan
	 * issue.getData()[Odd]: The URI of the invlaid verification plan named prior
	 */
	@Fix(AlisaValidator.ASSURANCE_PLAN_OWN_INVALID_VERIFICATION_PLANS)
	def public void fixInvalidOwnVerificationPlans(Issue issue, IssueResolutionAcceptor acceptor) {
		val name = issue.getData.head
		val vpUri = issue.getData.get(1)
		acceptor.accept(issue, "Remove verification plan '" + name + "' from 'assure'", null, null,
				new ISemanticModification() {
					override apply(EObject element, IModificationContext context) throws Exception {
						val assurancePlan = element as AssurancePlan
						val ResourceSet resourceSet = element.eResource().getResourceSet()
						assurancePlan.assure.remove(resourceSet.getEObject(URI.createURI(vpUri), true) as VerificationPlan)
					}
				});
	}
}