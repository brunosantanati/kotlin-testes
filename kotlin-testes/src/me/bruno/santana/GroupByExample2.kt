package me.bruno.santana

data class RuleConfiguration(
    val ruleName: String,
    val variantId: String,
    val value: Double
)

fun main() {
    val ruleConfigurations = listOf(
        RuleConfiguration(ruleName = "atm_1", variantId = "BASE", value = 10.0),
        RuleConfiguration(ruleName = "atm_1", variantId = "OTHER", value = 20.0),
        RuleConfiguration(ruleName = "spend_1", variantId = "BASE", value = 10.0),
        RuleConfiguration(ruleName = "spend_1", variantId = "OTHER", value = 20.0),
        RuleConfiguration(ruleName = "spend_1", variantId = "OTHER2", value = 30.0),
        RuleConfiguration(ruleName = "my_rule_1", variantId = "BASE", value = 10.0),
        RuleConfiguration(ruleName = "my_rule_1", variantId = "OTHER2", value = 30.0))

    val mapOfGroupedRuleConfigurations = ruleConfigurations.groupBy { it.ruleName }
    println(mapOfGroupedRuleConfigurations)

    val listOfRuleConfigurations = getRuleConfigurationsByVariantId(
        variantId = "OTHER",
        mapOfRuleConfigurations = mapOfGroupedRuleConfigurations
    )
    println(listOfRuleConfigurations)
}

fun getRuleConfigurationsByVariantId(
    variantId: String,
    mapOfRuleConfigurations: Map<String, List<RuleConfiguration>>): List<RuleConfiguration>{

    val listOfRuleConfigurations = mutableListOf<RuleConfiguration>()

    mapOfRuleConfigurations.forEach { mapEntry ->
        val ruleConfiguration: RuleConfiguration? = mapEntry.value.find { it.variantId == variantId } ?:
            mapEntry.value.find { it.variantId == "BASE" }
        ruleConfiguration?.apply { listOfRuleConfigurations.add(this) }
    }

    return listOfRuleConfigurations
}