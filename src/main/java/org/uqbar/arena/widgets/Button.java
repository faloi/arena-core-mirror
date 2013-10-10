package org.uqbar.arena.widgets;

import org.uqbar.arena.bindings.ObservableCaption;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ButtonBuilder;
import org.uqbar.lacar.ui.model.NoopAction;
import org.uqbar.lacar.ui.model.PanelBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

import com.uqbar.commons.collections.Closure;


/**
 * No hay mucho para decir, es un {@link Control} de tipo "boton"
 * Tiene un texto {@link #caption}.
 * Lo interesante es que utiliza el patrón <<strategy>>
 * Cuando el usuario presiona el botón, éste, delega el evento
 * a un objeto de tipo {@link Action} que el desarrollador debe/puede
 * configurar.
 * 
 * El {@link Action} deberá ser responsable de ejecutar el comportamiento
 * deseado de dominio y de controller/vista.
 * 
 * Por default tiene un {@link NoopAction}.
 * 
 * @author npasserini
 */
public class Button extends SkinnableControl {
	private String caption = this.nextCaption();
	private Action onClick = new NoopAction();
	public Button(Container container) {
		super(container);
	}

	// ********************************************************
	// ** Configurations
	// ********************************************************

	public Button setCaption(String caption) {
		this.caption = caption;
		return this;
	}

	public Button onClick(Action onClick) {
		this.onClick = onClick;
		return this;
	}
	
	protected String getCaption(){
		return this.caption;
	}

	public Button setAsDefault() {
		this.addConfiguration(new Closure<ButtonBuilder>() {
			@Override
			public void execute(ButtonBuilder builder) {
				builder.setAsDefault();
			}
		});
		return this;
	}

	public Button disableOnError() {
		this.addConfiguration(new Closure<ButtonBuilder>() {
			@Override
			public void execute(ButtonBuilder builder) {
				builder.disableOnError();
			}
		});
		return this;
	}
	
	// ********************************************************
	// ** Binding
	// ********************************************************
	
	public Binding bindCaptionToProperty(String propertyName) {
		return this.addBinding(new ObservableProperty(propertyName), new ObservableCaption());
	}
	
	// ********************************************************
	// ** Rendering
	// ********************************************************

	@Override
	protected ButtonBuilder createBuilder(PanelBuilder container) {
		final ButtonBuilder button = container.addButton(this.caption, this.onClick);
		this.configureSkineableBuilder(button);
		return button;
	}
}
