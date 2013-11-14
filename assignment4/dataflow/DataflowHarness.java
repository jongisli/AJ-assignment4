package assignment4.dataflow;

import assignment4.processors.DiscomfortProcessor;
import assignment4.processors.DiscomfortWarning;
import assignment4.processors.PrinterProcessor;
import assignment4.processors.SensorReading;
import assignment4.processors.SensorReadingGenerator;
import assignment4.processors.StartSignal;

public class DataflowHarness {
	public static void main(String[] args) {
		//DynamicCheckedNode sensor1 = new DynamicCheckedNode(new SensorReadingGenerator());
		//DynamicCheckedNode sensor2 = new DynamicCheckedNode(new SensorReadingExtendedGenerator());
		
		//DynamicCheckedNode monitor1 = new DynamicCheckedNode(new DiscomfortProcessor());
		//sensor1.subscribe(monitor1);
		//sensor2.subscribe(monitor1);
		/*
		DynamicCheckedNode subscriber1 = new DynamicCheckedNode(new PrinterProcessor<DiscomfortWarning>("Printer 1"));
		monitor1.subscribe(subscriber1);
		
		//DynamicCheckedNode subscriber2 = new DynamicCheckedNode(new PrinterProcessor<Object>("Printer 2"));
		//monitor1.subscribe(subscriber2);
		
		
		*/
		Node<StartSignal, SensorReading> sensor1 = new Node<StartSignal, SensorReading>(new SensorReadingGenerator());
		Node<StartSignal, SensorReading> sensor2 = new Node<StartSignal, SensorReading>(new SensorReadingGenerator());
		Node<StartSignal, SensorReading> sensor3 = new Node<StartSignal, SensorReading>(new SensorReadingGenerator());


		
		Node<SensorReading, DiscomfortWarning> monitor1 = new Node<SensorReading, DiscomfortWarning>(new DiscomfortProcessor());
		Node<SensorReading, DiscomfortWarning> monitor2 = new Node<SensorReading, DiscomfortWarning>(new DiscomfortProcessor());
		sensor1.subscribe(monitor1);
		sensor2.subscribe(monitor1);
		sensor2.subscribe(monitor2);
		sensor3.subscribe(monitor2);

		
		Node<DiscomfortWarning, Object> subscriber1 = new Node<DiscomfortWarning, Object>(new PrinterProcessor<DiscomfortWarning>("Printer 1"));
		Node<DiscomfortWarning, Object> subscriber2 = new Node<DiscomfortWarning, Object>(new PrinterProcessor<DiscomfortWarning>("Printer 1"));
		monitor1.subscribe(subscriber1);
		monitor2.subscribe(subscriber1);
		monitor2.subscribe(subscriber2);


		sensor1.start();
		sensor2.start();
		sensor3.start();
		monitor1.start();
		monitor2.start();
		subscriber1.start();
		subscriber2.start();
		
		sensor1.push(StartSignal.go);
		sensor2.push(StartSignal.go);
		sensor3.push(StartSignal.go);
		
		
	}
}
