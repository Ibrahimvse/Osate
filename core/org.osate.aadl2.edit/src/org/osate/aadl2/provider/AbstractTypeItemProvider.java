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
package org.osate.aadl2.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AbstractType;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.AbstractType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractTypeItemProvider extends ComponentTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTypeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Aadl2Package.eINSTANCE.getAbstractType_OwnedBusAccess());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getAbstractType_OwnedDataAccess());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getAbstractType_OwnedSubprogramAccess());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getAbstractType_OwnedDataPort());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getAbstractType_OwnedEventPort());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getAbstractType_OwnedEventDataPort());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getAbstractType_OwnedSubprogramGroupAccess());
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns AbstractType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AbstractType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((AbstractType) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_AbstractType_type")
				: getString("_UI_AbstractType_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AbstractType.class)) {
		case Aadl2Package.ABSTRACT_TYPE__OWNED_BUS_ACCESS:
		case Aadl2Package.ABSTRACT_TYPE__OWNED_DATA_ACCESS:
		case Aadl2Package.ABSTRACT_TYPE__OWNED_SUBPROGRAM_ACCESS:
		case Aadl2Package.ABSTRACT_TYPE__OWNED_DATA_PORT:
		case Aadl2Package.ABSTRACT_TYPE__OWNED_EVENT_PORT:
		case Aadl2Package.ABSTRACT_TYPE__OWNED_EVENT_DATA_PORT:
		case Aadl2Package.ABSTRACT_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getAbstractType_OwnedBusAccess(),
				Aadl2Factory.eINSTANCE.createBusAccess()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getAbstractType_OwnedDataAccess(),
				Aadl2Factory.eINSTANCE.createDataAccess()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getAbstractType_OwnedSubprogramAccess(),
				Aadl2Factory.eINSTANCE.createSubprogramAccess()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getAbstractType_OwnedDataPort(),
				Aadl2Factory.eINSTANCE.createDataPort()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getAbstractType_OwnedEventPort(),
				Aadl2Factory.eINSTANCE.createEventPort()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getAbstractType_OwnedEventDataPort(),
				Aadl2Factory.eINSTANCE.createEventDataPort()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getAbstractType_OwnedSubprogramGroupAccess(),
						Aadl2Factory.eINSTANCE.createSubprogramGroupAccess()));
	}

}