package org.uqbar.arena.widgets.tables.labelprovider;

import org.uqbar.lacar.ui.model.LabelProvider;

import com.uqbar.commons.collections.Transformer;

/**
 * Base class for reusing code.
 * 
 * @author jfernandes
 * @param <T>
 */
public abstract class AbstractPropertyLabelProvider<M, T> implements LabelProvider<M> {
	protected final String propertyName;
	protected Transformer<?, T> transformer;

	public AbstractPropertyLabelProvider(String propertyName2) {
		this.propertyName = propertyName2;
	}

	public AbstractPropertyLabelProvider(String propertyName, Transformer transformer) {
		this.propertyName = propertyName;
		this.transformer = transformer;
	}

	public <P> void setTransformer(Transformer<P, T> transformer) {
		this.transformer = transformer;
	}

}