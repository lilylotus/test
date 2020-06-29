package cn.nihility.selector;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@Configuration
@ComponentScan(basePackages = {"cn.nihility.selector"})
@Import(MyImportSelector.class)
public class ImportSelectorConfig {
}
